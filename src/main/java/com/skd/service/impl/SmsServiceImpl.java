/**  
 * @Title: SmsServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
package com.skd.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skd.dao.UserDao;
import com.skd.pojo.User;
import com.skd.service.SmsService;

/**
 * ClassName: SmsServiceImpl 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
@Service("smsServiceImpl")
public class SmsServiceImpl implements SmsService {
	
	Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
	@Autowired
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see com.skd.service.SmsService#chechSMS(java.lang.String)
	 */
	public String chechSMS(String phone) {
		User user = new User();
		user.setPhone(phone);
		if(userDao.getUsers(user, null, null).size() == 0){
			/*1、执行获取短信验证码工具类
			 *2、将手机号及其短信验证码存入redis，设置过期时间60s
			 */
		}
		return null;
	}

}
