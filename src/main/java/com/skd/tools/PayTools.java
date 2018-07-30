/**  
 * @Title: PayTools.java
 * @Package com.skd.tools
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月13日
 */
package com.skd.tools;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: PayTools 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月13日
 */
public class PayTools {
	/**
	 * 支付宝，第三方支付接口，返回第三方支付订单号等信息
	 * @Description: TODO
	 * @param @param param
	 * @return Map<String,Object>  
	 * @author zhaoqian
	 * @date 2018年5月13日
	 */
	public static Map<String, Object> aliPay(Map<String, Object> paramMap){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("success", "true");
		resultMap.put("otherPayId", "XXXXXXXXX");
		return resultMap;
	}
	/**
	 * 微信支付接口，返回支付订单号等信息
	 * @Description: TODO
	 * @param @param paramMap
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年5月13日
	 */
	public static Map<String, Object> weChatPay(Map<String, Object> paramMap){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("success", "true");
		resultMap.put("otherPayId", "XXXXXXXXX");
		return resultMap;
	}

}
