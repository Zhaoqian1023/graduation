/**  
 * @Title: OrderServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月3日
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

import com.skd.dao.DeliverPriceDao;
import com.skd.dao.OrderDao;
import com.skd.dao.ProductDao;
import com.skd.pojo.DeliverPrice;
import com.skd.pojo.Order;
import com.skd.pojo.Product;
import com.skd.redis.RedisUtil;
import com.skd.service.OrderService;
import com.skd.utils.Constants;
import com.skd.utils.DateUtil;
import com.skd.utils.JSONUtil;
import com.skd.utils.OrderStatus;
import com.skd.utils.PrimaryKeyUtil;

/**
 * ClassName: OrderServiceImpl
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月3日
 */
@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private DeliverPriceDao deliverPriceDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skd.service.OrderService#createOrder(java.lang.String,
	 * java.lang.String)
	 */
	public Map<String, Object> createOrder(String token, String productMap,
			String deliverMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<String> orderIds = new ArrayList<String>();
		String userId = redisUtil.hget(Constants.Token_USER, token) == null ? null
				: redisUtil.hget(Constants.Token_USER, token).toString();
		logger.info("====" + token + "------token-------------" + userId);
		if (userId != null) {
			@SuppressWarnings("unchecked")
			Map<String, Object> productInfoMap = (Map<String, Object>) JSONUtil
					.jsonToMap(productMap);
			@SuppressWarnings("unchecked")
			Map<String, Object> deliverInfoMap = (Map<String, Object>) JSONUtil
					.jsonToMap(deliverMap);
			Object[] objects = productInfoMap.keySet().toArray();
			List<String> remoList = new ArrayList<String>();
			String[] products = new String[objects.length];
			int money = 0;
			for (int i = 0; i < objects.length; i++) {
				logger.info(objects[i].toString()+"------11111--------");
				products[i] = objects[i].toString();
			}
			List<Product> dataList = productDao.getList(products);
			logger.info(dataList.size() + "=========products====="+products);
			/**
			 * 封装订单对象，进行实例化
			 */
			if (dataList != null && dataList.size() > 0) {
				for (Product product : dataList) {
					/**
					 * 判断库存
					 */
					if (productInfoMap.get(product.getPid()) == null
							|| product.getStorage() < Double
									.parseDouble(productInfoMap.get(
											product.getPid()).toString())) {
						continue;
					}

					/**
					 * 获取运费
					 */
					DeliverPrice deliverPrice = new DeliverPrice();
					deliverPrice.setId(product.getDeliverPrice());
					List<Map<String, Object>> deliverPrices = deliverPriceDao
							.findObjects(deliverPrice, null, null);
					/**
					 * 生成订单
					 */
					Order order = new Order();
					order.setOrderId(PrimaryKeyUtil.createOrderId());
					order.setOrderTime(DateUtil.getNowDate());
					order.setPriceNow(product.getPriceNow());
					order.setProductModel(product.getProductModel());
					order.setProductCount(Double.parseDouble(productInfoMap
							.get(product.getPid()).toString() == null ? "0"
							: productInfoMap.get(product.getPid()).toString()));
					order.setStatus(OrderStatus.STATUS0);
					order.setDeliverPrice(Integer.parseInt(deliverPrices.get(0)
							.get("NORMAL_PRICE").toString() == null ? "0"
							: deliverPrices.get(0).get("NORMAL_PRICE")
									.toString())
							/ dataList.size());
					order.setReceiverId(Integer.parseInt(deliverInfoMap.get(
							product.getPid()).toString() == null ? "1"
							: deliverInfoMap.get(product.getPid()).toString()));
					order.setProductId(product.getPid());
					order.setStoreId(product.getStoreId());
					order.setUserId(userId);
					orderDao.insert(order);
					orderIds.add(order.getOrderId());
					/**
					 * 更新商品库存
					 */
					Product newProduct = new Product();
					newProduct.setPid(product.getPid());
					newProduct.setStorage(product.getStorage()
							- Double.parseDouble(productInfoMap.get(
									product.getPid()).toString()));
					productDao.updateProductSelectiveByKey(newProduct);
					/**
					 * 订单总价值：商品现价*数量+总运费/订单数量
					 */
					money += product.getPriceNow() * order.getProductCount()
							+ order.getDeliverPrice();
					/**
					 * 判断购物车中是否含该商品
					 */
					Double num = Double.parseDouble(redisUtil.hget(userId,
							product.getPid()) == null ? "0" : redisUtil.hget(
							userId, product.getPid()).toString());
					if (order.getProductCount() - num == Double.valueOf(0.0)) {
						remoList.add(product.getPid());
					}
					resultMap.put("orderIds", orderIds.toArray());
					resultMap.put("money", money);
				}
			}
			/**
			 * 删除购物车中包含的商品
			 */
			if (remoList.size() > 0) {
				redisUtil.hdel(userId, remoList.toArray());
			}
			
			logger.info(resultMap.toString()+"-----------");
			return resultMap;
		}
		return null;

	}

}
