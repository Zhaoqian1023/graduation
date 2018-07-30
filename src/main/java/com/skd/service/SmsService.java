/**  
 * @Title: SmsService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
package com.skd.service;

/**
 * ClassName: SmsService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
public interface SmsService {
	/**
	 * 审核手机号合法性，返回验证码
	 * @Description: TODO
	 * @param @param phone
	 * @return String  
	 * @author zhaoqian
	 * @date 2018年5月1日
	 */
	public String chechSMS(String phone);

}
