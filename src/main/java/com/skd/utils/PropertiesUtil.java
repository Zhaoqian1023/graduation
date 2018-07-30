/**  
 * @Title: PropertiesUtil.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月27日
 */
package com.skd.utils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

/**
 * ClassName: PropertiesUtil 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月27日
 */
public class PropertiesUtil {
	
	public static Properties getConfigProperties() throws Exception {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("properties/config.properties"));
		try {
			propertiesFactoryBean.afterPropertiesSet();
			return propertiesFactoryBean.getObject();
		} catch (IOException e) {
			throw new Exception("read config.properties file error,"+e.getMessage());
		}
	}
	

}
