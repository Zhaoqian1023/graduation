/**  
 * @Title: DeliverPriceServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
package com.skd.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.skd.common.PageObject;
import com.skd.dao.DeliverPriceDao;
import com.skd.dao.StoreDao;
import com.skd.pojo.DeliverPrice;
import com.skd.pojo.Store;
import com.skd.redis.RedisUtil;
import com.skd.service.DeliverPriceService;
import com.skd.utils.Constants;

/**
 * ClassName: DeliverPriceServiceImpl 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
@Service("deliverPriceServiceImpl")
public class DeliverPriceServiceImpl implements DeliverPriceService {
	Logger logger = LoggerFactory.getLogger(DeliverPriceServiceImpl.class);
	@Autowired
	private DeliverPriceDao deliverPriceDao;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	StoreDao storeDao;
	/* (non-Javadoc)
	 * @see com.skd.service.DeliverPriceService#getDeliverPrice(java.lang.String, java.lang.String)
	 */
	public List<Map<String, Object>> getDeliverPrice(String token,
			String pageObject) {
		
		DeliverPrice dPrice = new DeliverPrice();
		PageObject pObject = null;
		if(pageObject != null){
			pObject = JSONObject.parseObject(pageObject, PageObject.class);
		}
		String userId = redisUtil.hget(Constants.Token_USER, token) == null?null:redisUtil.hget(Constants.Token_USER, token).toString();
		if(userId != null){
			Store store = new Store();
			store.setUserId(userId);
			List<Store> stores = storeDao.getStores(store, null, null);
			if(stores == null || stores.size() == 0 ){
				return null;
			}
			dPrice.setStore(stores.get(0).getSid());
			return deliverPriceDao.findObjects(dPrice, pObject, null);
		}
		return null;
	}

}
