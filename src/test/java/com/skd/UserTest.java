/**  
 * @Title: UserTest.java
 * @Package com.skd.user
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skd.dao.UserDao;
import com.skd.pojo.User;
import com.skd.service.UserService;

/**
 * ClassName: UserTest 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
public class UserTest {
	
	@Test
	public void run(){
		this.testQueryByUser1();
		
	}
	
	public void testQueryByUser(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		String uid = "371520180416131524456";
		User user = new User();
		user.setUserId(uid);
		System.out.println(userDao.getUsers(user, null, null).size());
	}
	public void testQueryByUser1(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		String phone = "371520180416131524456";
		User user = new User();
		user.setPhone(phone);
		System.out.println(userDao.getUsers(user, null, null).size());
	}

}
