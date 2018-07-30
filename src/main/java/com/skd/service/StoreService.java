/**  
 * @Title: StoreService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月4日
 */
package com.skd.service;

import java.util.Map;

/**
 * ClassName: StoreService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月4日
 */
public interface StoreService {

	/**获取店铺商品列表
	 * @Description: TODO
	 * @param @param token
	 * @param @param storeId
	 * @param @return   
	 * @return Map<String,Object> 
	 * @throws
	 * @author zhaoqian
	 * @date 2018年6月4日
	 */
	Map<String, Object> getProducts(String token,String storeId);
	

}
