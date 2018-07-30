/**  
 * @Title: StoreServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月4日
 */
package com.skd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skd.dao.FavoriteDao;
import com.skd.dao.ProductDao;
import com.skd.dao.StoreDao;
import com.skd.pojo.Favorite;
import com.skd.pojo.Product;
import com.skd.redis.RedisUtil;
import com.skd.service.StoreService;
import com.skd.utils.Constants;
import com.skd.utils.StringUtil;

/**
 * ClassName: StoreServiceImpl 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月4日
 */
@Service("storeServiceImpl")
public class StoreServiceImpl implements StoreService {
	Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private FavoriteDao favoriteDao;

	/* (non-Javadoc)
	 * @see com.skd.service.StoreService#getProducts(java.lang.String,java.lang.String)
	 */
	public Map<String, Object> getProducts(String token,String storeId) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		/**
		 * 封装当前店铺的信息
		 */
		Map<String, Object> storeInfo = storeDao.findById(storeId);
		storeInfo.remove("IDENTITY_1_URL");
		storeInfo.remove("IDENTITY_2_URL");
		storeInfo.remove("STATUS");
		storeInfo.remove("LICENSE");
		storeInfo.remove("APPLY_PASS");
		storeInfo.remove("APPLY_TIME");
		data.put("storeInfo", storeInfo);
		/**
		 * 封装当前店铺中商品信息
		 */
		Product product = new Product();
		product.setStoreId(storeId);
		product.setStatus(1);
		List<Map<String, Object>> products = productDao.findObjects(product, null, null);
		data.put("productList", products);
		/**
		 * 判断是否收藏该店
		 */
		if(StringUtil.isNotBlank(token)){
			String userId = redisUtil.hget(Constants.Token_USER, token) == null ? null
					: redisUtil.hget(Constants.Token_USER, token).toString();
			Favorite favorite = new Favorite();
			favorite.setfUid(userId);
			favorite.setStatus(1);
			favorite.setfType(2);
			favorite.setfKey(storeId);
			List<Map<String, Object>> favorites = favoriteDao.findObjects(favorite, null, null);
			if(favorites != null && favorites.size()>0){
				data.put("favorite", "1");
			}else{
				data.put("favorite", "0");
			}
		}else{
			data.put("favorite", "0");
		}
		return data;
	}

}
