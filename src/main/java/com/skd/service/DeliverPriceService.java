/**  
 * @Title: DeliverPriceService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
package com.skd.service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: DeliverPriceService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
public interface DeliverPriceService {
	/**
	 * 查询运费标准
	 * @Description: TODO
	 * @param @param token
	 * @param @param pageObject
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年5月27日
	 */
	public List<Map<String, Object>> getDeliverPrice(String token,String pageObject);

}
