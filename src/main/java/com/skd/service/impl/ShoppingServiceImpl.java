/**  
 * @Title: ShoppingServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
package com.skd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skd.dao.ProductDao;
import com.skd.redis.RedisUtil;
import com.skd.service.ShoppingService;
import com.skd.utils.Constants;

/**
 * ClassName: ShoppingServiceImpl
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
@Service("shoppingServiceImpl")
public class ShoppingServiceImpl implements ShoppingService {

	Logger logger = LoggerFactory.getLogger(ShoppingServiceImpl.class);

	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private ProductDao productDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skd.service.ShoppingService#addShopping(java.lang.String,
	 * java.lang.String)
	 */
	public boolean addShopping(String token, String productId, String count) {
		String userId = redisUtil.hget(Constants.Token_USER, token) == null ? null
				: redisUtil.hget(Constants.Token_USER, token).toString();
		if (userId != null) {
			/**
			 * 缓存中存储购物车，key为用户ID，Map<商品ID,商品数量>
			 */
			return redisUtil.hincr(userId, productId, Integer.parseInt(count)) > 0;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skd.service.ShoppingService#clearShopping(java.lang.String)
	 */
	public boolean clearShopping(String token) {
		String userId = redisUtil.hget(Constants.Token_USER, token) == null ? null
				: redisUtil.hget(Constants.Token_USER, token).toString();
		if (userId != null) {
			redisUtil.del(userId);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skd.service.ShoppingService#delShopping(java.lang.String,
	 * java.lang.String[])
	 */
	public boolean delShopping(String token, String[] productId) {
		String userId = redisUtil.hget(Constants.Token_USER, token) == null ? null
				: redisUtil.hget(Constants.Token_USER, token).toString();
		Object[] temp = productId;
		if (userId != null) {
			redisUtil.hdel(userId, temp);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skd.service.ShoppingService#getShopping(java.lang.String)
	 */
	public List<Map<String, Object>> getShopping(String token) {
		String userId = redisUtil.hget(Constants.Token_USER, token) == null ? null
				: redisUtil.hget(Constants.Token_USER, token).toString();
		if (userId != null) {
			Map<Object, Object> shoppingMap = new HashMap<Object, Object>();
			shoppingMap = redisUtil.hmget(userId);
			if (!shoppingMap.isEmpty()) {
				/**
				 * 查询商品及其店铺信息
				 */
				Object[] productIds = shoppingMap.keySet().toArray();
				String[] tempProductId = new String[productIds.length];
				for (int i = 0; i < productIds.length; i++) {
					tempProductId[i] = String.valueOf(productIds[i]);
				}
				List<Map<String, Object>> details = productDao
						.getShoppingProduct(tempProductId);
				/**
				 * 对商品按照店铺分组
				 */
				Set<List<Map<String, Object>>> tempList = new HashSet<List<Map<String, Object>>>();
				for (int i = 0; i < details.size(); i++) {
					List<Map<String, Object>> temp1 = new ArrayList<Map<String, Object>>();
					for (int j = 0; j < details.size(); j++) {
						if (details.get(i).get("STORE_ID")
								.equals(details.get(j).get("STORE_ID"))) {
							temp1.add(details.get(j));
						}
					}
					tempList.add(temp1);
				}
				/**
				 * 封装json结果集
				 */
				List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
				for (List<Map<String, Object>> list : tempList) {
					Map<String, Object> data = new HashMap<String, Object>();
					List<Map<String, Object>> productList = new ArrayList<Map<String,Object>>();
					data.put("storeId", list.get(0).get("STORE_ID"));
					data.put("storeName", list.get(0).get("STORE_NAME"));
					for (Map<String, Object> map : list) {
						if (Float.parseFloat(map.get("STORAGE").toString()) > Float
								.parseFloat(shoppingMap.get(map.get("PID"))
										.toString())) {
							map.put("COUNT", shoppingMap.get(map.get("PID")));

						}else{
							map.put("COUNT", map.get("STORAGE").toString());
						}
						map.remove("STORAGE");
						map.remove("STORE_ID");
						map.remove("STORE_NAME");
						productList.add(map);
					}
					data.put("product", productList);
					result.add(data);
				}
				return result;

			}

		}
		return null;
	}

}
