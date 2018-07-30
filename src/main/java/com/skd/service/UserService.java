/**  
 * @Title: UserService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd.service;

import java.util.Map;

import com.skd.pojo.User;

/**
 * ClassName: UserService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
public interface UserService {
	
	/**
	 * 
	 * @Description: 登录校验,返回用户ID和token
	 * @param @param user
	 * @return Map<String, Object>   
	 * @author zhaoqian
	 * @date 2018年4月29日
	 */
	public Map<String, Object> loginCheck(User user);
	
	/**
	 * 
	 * @Description: 保存用户信息，返回用户id
	 * @param @param user
	 * @return String  
	 * @author zhaoqian
	 * @date 2018年4月29日
	 */
	public String saveUser(User user);
	

	/**
	 * @Description: 返回用户ID
	 * @param @param phone
	 * @param @param uPwd   
	 * @return String   
	 * @author zhaoqian
	 * @date 2018年4月30日
	 */
	public String register(String phone, String uPwd);

	/**
	 * @Description: TODO
	 * @param @param token
	 * @return boolean  
	 * @author zhaoqian
	 * @date 2018年5月2日
	 */
	public boolean logout(String token);
	
	

}
