/**  
 * @Title: PayServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月13日
 */
package com.skd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skd.dao.OrderDao;
import com.skd.dao.PayDao;
import com.skd.dao.ProductDao;
import com.skd.dao.ProductTypeDao;
import com.skd.dao.UserDao;
import com.skd.pojo.Order;
import com.skd.pojo.Pay;
import com.skd.pojo.ProductType;
import com.skd.pojo.User;
import com.skd.redis.RedisUtil;
import com.skd.service.PayService;
import com.skd.service.TaskService;
import com.skd.tools.PayTools;
import com.skd.utils.Constants;
import com.skd.utils.DateUtil;
import com.skd.utils.ObjectUtil;
import com.skd.utils.OrderStatus;
import com.skd.utils.PrimaryKeyUtil;

/**
 * ClassName: PayServiceImpl
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月13日
 */
@Service("payServiceImpl")
public class PayServiceImpl implements PayService {
	Logger logger = LoggerFactory.getLogger(PayServiceImpl.class);
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private PayDao payDao;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductTypeDao productTypeDao;
	@Autowired
	private UserDao userDao;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skd.service.PayService#createPay(java.lang.String,
	 * java.lang.String, java.lang.String[])
	 */
	public Map<String, Object> createPay(String token, String payType,
			String[] orderIds) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> payResult = new HashMap<String, Object>();
		String userId = redisUtil.hget(Constants.Token_USER, token) == null ? null
				: redisUtil.hget(Constants.Token_USER, token).toString();
		if (userId != null) {
			List<Order> orders = orderDao.getOrdersByID(orderIds);
			List<Order> newOrders = new ArrayList<Order>();
			Map<String, Object> payInfoMap = new HashMap<String, Object>();
			/**
			 * 封装特色商品类别
			 */
			ProductType productType = new ProductType();
			productType.setFirst("特色商品");
			List<ProductType> productTypes = productTypeDao.findProductType(productType, null, null);
			List<Integer> pidStrings = new ArrayList<Integer>();
			List<String> orderIdTemp = new ArrayList<String>();
			for (ProductType pType : productTypes) {
				pidStrings.add(pType.getId());
			}
			
			/**
			 * 计算需要支付的金额
			 */
			int money = 0;
			if(orders.size() == 0){
				return null;
			}
			for (Order order : orders) {
				/**
				 * 计算实付金额,商品现价*数量+运费
				 */
				Order newOrder = new Order();
				int tempMony = (int) (order.getPriceNow()
						* order.getProductCount() + order.getDeliverPrice());
				money += tempMony;
				/**
				 * 更新订单状态
				 */
				newOrder.setRealMoney(tempMony);
				newOrder.setPayTime(DateUtil.getNowDate());
				newOrder.setOrderId(order.getOrderId());
				newOrders.add(newOrder);
				/**
				 * 判断该订单是否为特色商品订单
				 */
				Map<String, Object> productTemp = productDao.findById(order.getProductId());
				if(pidStrings.contains(Integer.parseInt(productTemp.get("PRODUCT_TYPE").toString()))){
					/**
					 * 判断用户信息是否完善
					 */
					User user = userDao.findUserById(userId);
					boolean isNull = false;
					try {
						isNull = ObjectUtil.checkUserIsNull(user);
					} catch (IllegalAccessException e) {
						logger.error("错误！！！！"+e.getMessage());
					}
					if(isNull){
						logger.info("------用户信息不完善，无法完成支付------");
						return null;
					}
					
					orderIdTemp.add(order.getOrderId());
				}
				
			}
			payInfoMap.put("money", money);
			/**
			 * 请求第三方支付
			 */
			if (Constants.PAY_TYPE_ALIPAY.equals(payType)) {
				payResult = PayTools.aliPay(payInfoMap);

			} else if (Constants.PAY_TYPE_WECHAT.equals(payType)) {
				payResult = PayTools.weChatPay(payInfoMap);
			}
			if (Boolean.parseBoolean(payResult.get("success").toString())) {
				List<String> paysId = new ArrayList<String>();
				for (Order newOrder : newOrders) {
					/**
					 * 创建支付订单
					 */
					Pay pay = new Pay();
					pay.setPayId(PrimaryKeyUtil.createPayId());
					pay.setOrderId(newOrder.getOrderId());
					pay.setPayMoney(newOrder.getRealMoney());
					pay.setPayType(Integer.parseInt(payType));
					pay.setPayTime(DateUtil.getNowDate());
					pay.setOtherId(payResult.get("otherPayId") == null ? null
							: payResult.get("otherPayId").toString());
					newOrder.setPayTime(pay.getPayTime());
					newOrder.setStatus(OrderStatus.STATUS1);
					orderDao.updateByPrimaryKeySelective(newOrder);
					payDao.insert(pay);
					paysId.add(pay.getPayId());
					
				}
				returnMap.put("paysId", paysId.toArray());
				/**
				 * 若是特殊商品，自动创建抢单任务
				 */
				
				if(orderIdTemp.size() >0){
					logger.info("-----------自动发布新任务--------orderIdTemp："+orderIdTemp.size());
					taskService.autoPublish(userId, orderIdTemp);
				}
			}
			
		}
		return returnMap;
	}

}
