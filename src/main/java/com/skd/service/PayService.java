/**  
 * @Title: PayService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月13日
 */
package com.skd.service;

import java.util.Map;

/**
 * ClassName: PayService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月13日
 */
public interface PayService {
	/**
	 * 创建新订单，返回支付ID
	 * @Description: TODO
	 * @param @param token
	 * @param @param payType
	 * @param @param orderIds
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年5月13日
	 */
	public Map<String, Object> createPay(String token,String payType,String[] orderIds);

}
