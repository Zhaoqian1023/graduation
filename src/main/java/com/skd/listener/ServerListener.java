/**  
 * @Title: ServerListener.java
 * @Package com.skd.listener
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
package com.skd.listener;

import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.skd.redis.RedisUtil;
import com.skd.service.AuthorityService;
import com.skd.service.impl.AuthorityServiceImpl;
import com.skd.utils.Constants;

/**
 * ClassName: ServerListener
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
public class ServerListener implements ServletContextListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		AuthorityService authorityService = WebApplicationContextUtils
				.getWebApplicationContext(sce.getServletContext()).getBean(
						AuthorityServiceImpl.class);
		RedisUtil redisUtil = WebApplicationContextUtils
				.getWebApplicationContext(sce.getServletContext()).getBean(
						RedisUtil.class);
		/**
		 * 初始化访客权限
		 */
		Set<String> dataSet = authorityService.getAuthority(0);
		String defaultToken = Constants.PUBLIC_ROLE;
		redisUtil.sSet(defaultToken, dataSet.toArray());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
