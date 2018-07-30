/**  
 * @Title: AuthorityTest.java
 * @Package com.skd
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
package com.skd;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skd.dao.AuthorityDao;
import com.skd.pojo.Authority;
import com.skd.service.AuthorityService;

/**
 * ClassName: AuthorityTest 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
public class AuthorityTest {
	
	
	@Test
	public void run(){
		queryService();
	}
	
	public void query(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		AuthorityDao authorityDao = (AuthorityDao) ctx.getBean("authorityDao");
		Authority authority = new Authority();
		authority.setInterfaceType(0);
		List<Authority> dataAuthorities = authorityDao.getAuthorities(authority);
		for(Authority au :dataAuthorities){
			System.out.println(au.getContent());
		}
		
	}
	public void queryService(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		AuthorityService authorityService = (AuthorityService) ctx.getBean("authorityServiceImpl");
		Set<String> data = authorityService.getAuthority(0);
		for(String obj :data){
			System.out.println(obj);
		}
		
	}

}
