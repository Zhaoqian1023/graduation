/**  
 * @Title: StoreTest.java
 * @Package com.skd
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月28日
 */
package com.skd;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skd.dao.StoreDao;
import com.skd.pojo.Store;

/**
 * ClassName: StoreTest 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月28日
 */
public class StoreTest {
	@Test
	public void run(){
		this.testQueryById1();
		
	}
	public void testQueryById(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		StoreDao storeDao = (StoreDao) ctx.getBean("storeDao");
		Store store = new Store();
		store.setSid("371620180428130413234");
		List<Store> dataList = storeDao.getStores(store, null, null);
		System.out.println(dataList.get(0));
	}
	public void testQueryById1(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		StoreDao storeDao = (StoreDao) ctx.getBean("storeDao");
		Map<String, Object> data = storeDao.findById("371620180428130413234");
		System.out.println(data);
	}

}
