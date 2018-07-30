/**  
 * @Title: ProductImageTest.java
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

import com.skd.dao.ProductImageDao;

/**
 * ClassName: ProductImageTest 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月28日
 */
public class ProductImageTest {
	@Test
	public void run(){
		this.testQueryById();
		
	}
	
	public void testQueryById(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		ProductImageDao productImageDao = (ProductImageDao) ctx.getBean("productImageDao");
		List<Map<String, Object>> dataList = productImageDao.getImagesByProduct("3714201804280011", 1);
		System.out.println(dataList.get(0));
	}

}
