/**  
 * @Title: ProductServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月27日
 */
package com.skd.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.skd.common.PageObject;
import com.skd.dao.ProductDao;
import com.skd.dao.ProductImageDao;
import com.skd.dao.StoreDao;
import com.skd.pojo.Product;
import com.skd.pojo.ProductType;
import com.skd.pojo.Store;
import com.skd.redis.RedisUtil;
import com.skd.service.ProductService;
import com.skd.utils.Constants;
import com.skd.utils.PrimaryKeyUtil;

/**
 * ClassName: ProductServiceImpl 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月27日
 */
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductImageDao productImageDao;
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private RedisUtil redisUtil;
	
	/* (non-Javadoc)
	 * @see com.skd.service.ProductService#getProduct(int, java.lang.String, com.skd.common.PageObject, boolean)
	 */
	public List<Map<String, Object>> getProduct(ProductType productType,PageObject pageObject) {
		
		return productDao.getProductByTypeAndPage(pageObject, productType, null);
		
	}

	/* (non-Javadoc)
	 * @see com.skd.service.ProductService#getProductByQuality(int, com.skd.common.PageObject, boolean)
	 */
	public List<Map<String, Object>> getProductByQuality(ProductType producttype,
			PageObject pageObject, boolean desc) {
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		String rule = "PID";
		if (desc) {
			rule = "PID desc";
		}
		dataList = productDao.getProductByTypeAndPage(pageObject, producttype, rule);
		return dataList.size()>0?dataList:null;
	}

	/* (non-Javadoc)
	 * @see com.skd.service.ProductService#getProductBySales(int, com.skd.common.PageObject, boolean)
	 */
	public List<Map<String, Object>> getProductBySales(ProductType producttype,
			PageObject pageObject, boolean desc) {
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		String rule = "SALES";
		if (desc) {
			rule = "SALES desc";
		}
		dataList = productDao.getProductByTypeAndPage(pageObject, producttype, rule);
		return dataList.size()>0?dataList:null;
	}

	/* (non-Javadoc)
	 * @see com.skd.service.ProductService#getProductByPrice(int, com.skd.common.PageObject, boolean)
	 */
	public List<Map<String, Object>> getProductByPrice(ProductType producttype,
			PageObject pageObject, boolean desc) {
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		String rule = "PRICE_NOW";
		if (desc) {
			rule = "PRICE_NOW desc";
			
		}
		dataList = productDao.getProductByTypeAndPage(pageObject, producttype, rule);
		return dataList.size()>0?dataList:null;
	}

	/* (non-Javadoc)
	 * @see com.skd.service.ProductService#getIndexList(com.skd.common.PageObject)
	 */
	@Cacheable(value="indexProductShow#60*60*12",key="#root.targetClass+#root.methodName")
	public List<Map<String, Object>> getIndexList(PageObject pageObject,ProductType producttype) {
		
		return productDao.getIndexData(pageObject,producttype);
	}

	/* (non-Javadoc)
	 * @see com.skd.service.ProductService#getDetail(java.lang.String)
	 */
	@Cacheable(value="productDetail#60*60*12",key="#root.targetClass+#root.methodName+#productId")
	public Map<String, Object> getDetail(String productId) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Map<String, Object>> imageMap = new ArrayList<Map<String,Object>>();
		Map<String, Object> storeMap = new HashMap<String, Object>(); 
		Map<String, Object> productMap = new HashMap<String, Object>();
		
		productMap = productDao.findById(productId);
		if(productMap == null){
			return null;
		}
		productMap.put("STATISTICS", String.valueOf(productDao.statisticsSale(productId)));
		imageMap = productImageDao.getImagesByProduct(productId, 1);
		storeMap = storeDao.findById(productMap.get("STORE_ID").toString());
		/**
		 * 重新封装返回json
		 */
		productMap.remove("STATUS");
		Map<String,Object> newStore = new HashMap<String, Object>();
		newStore.put("LOCATION", storeMap.get("LOCATION"));
		newStore.put("PHONE", storeMap.get("PHONE"));
		newStore.put("STORE_NAME", storeMap.get("STORE_NAME"));
		newStore.put("SID", storeMap.get("SID"));
		
		
		dataMap.put("showImage", imageMap);
		dataMap.put("productInfo", productMap);
		dataMap.put("storeInfo", newStore);
		
		return dataMap;
	}

	/* (non-Javadoc)
	 * @see com.skd.service.ProductService#addProduct(java.lang.String, java.lang.String)
	 */
	public boolean addProduct(String token, String productInfo) {
		String userId = redisUtil.hget(Constants.Token_USER, token).toString();
		if(userId != null){
			Product product = JSONObject.parseObject(productInfo, Product.class);
			if(product != null){
				Store store = new Store();
				store.setStatus(0);
				store.setUserId(userId);
				List<Store> stores = storeDao.getStores(store, null, null);
				store = stores.get(0);
				product.setPid(PrimaryKeyUtil.createProductId());
				product.setStoreId(store.getSid());
				productDao.addProductSelective(product);
				return true;
			}
		}
		
		return false;
	}

}
