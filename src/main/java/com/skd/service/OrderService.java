/**  
 * @Title: OrderService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月3日
 */
package com.skd.service;

import java.util.Map;


/**
 * ClassName: OrderService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月3日
 */
public interface OrderService {
	/**
	 * 创建新订单，返回订单ID和待支付总金额
	 * @Description: TODO
	 * @param @param token
	 * @param @param productMap
	 * @param @param deliverMap
	 * @return Map<String,Object>  
	 * @author zhaoqian
	 * @date 2018年5月3日
	 */
	public Map<String, Object> createOrder(String token,String productMap,String deliverMap);

}
