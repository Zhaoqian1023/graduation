/**  
 * @Title: ReceiveAddrService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月14日
 */
package com.skd.service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: ReceiveAddrService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月14日
 */
public interface ReceiverAddrService {
	
	/**
	 * 获取用户收货地址
	 * @Description: TODO
	 * @param @param token
	 * @param @return   
	 * @return List<Map<String, Object>> 
	 * @throws
	 * @author zhaoqian
	 * @date 2018年5月14日
	 */
	public List<Map<String, Object>> getAddrByUser(String token);

}
