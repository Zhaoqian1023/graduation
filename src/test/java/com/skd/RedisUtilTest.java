/**  
 * @Title: RedisUtilTest.java
 * @Package com.skd
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月30日
 */
package com.skd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skd.redis.RedisUtil;
import com.skd.utils.Constants;

/**
 * ClassName: RedisUtilTest 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月30日
 */
public class RedisUtilTest {
	
	@Test
	public void run(){
		test3();
		
	}
	
	public void test(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		RedisUtil redisUtil = (RedisUtil) ctx.getBean("redisUtil");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("ddd", "zhaoqian");
		redisUtil.hmset("zhao", dataMap);
		Set<String> dataSet = new HashSet<String>();
		dataSet.add("dddd");
		dataSet.add("aaaa");
		dataSet.add("cccc");
		redisUtil.hset("test", "18769228023", dataSet);
		redisUtil.hset("smsMap", "18769228023", "12345",10);
		System.out.println(redisUtil.hget("zhao", "dd"));
		
	}
	public void test1(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		RedisUtil redisUtil = (RedisUtil) ctx.getBean("redisUtil");
		if(redisUtil.sHasKey("123456", "/login/register.do")){
			System.out.println(66666);
		}
		Set<Object> objects = (Set<Object>) redisUtil.hget(Constants.USER_ROLE, "37151525146741616");
		System.out.println(objects.toString());
		for (Object obj:objects) {
			Set<Object> dataObjects = (Set<Object>) obj;
			System.out.println(dataObjects.toString());
		}
		
	}
	public void test2(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		RedisUtil redisUtil = (RedisUtil) ctx.getBean("redisUtil");
		if(redisUtil.sHasKey("123456", "/login/register.do")){
			System.out.println(66666);
		}
		Set<Object> objects = (Set<Object>) redisUtil.sGet(Constants.PUBLIC_ROLE);
		System.out.println(redisUtil.hget(Constants.Token_USER, "W0JAN2I2MWZhNzA.").toString());
		
	}
	public void test3(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		RedisUtil redisUtil = (RedisUtil) ctx.getBean("redisUtil");
		redisUtil.hset(Constants.REGISTER_REDIS_SMS, "123456789", "1234");
		
		
	}

}
