/**  
 * @Title: ProductTypeService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
package com.skd.service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: ProductTypeService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
public interface ProductTypeService {
	
	/**
	 * 查询商品类别，通过商品类别对象
	 * @Description: TODO
	 * @param @param productType
	 * @param @param pageObject
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年5月27日
	 */
	public List<Map<String, Object>> getProductType(String productType,String pageObject);
	

}
