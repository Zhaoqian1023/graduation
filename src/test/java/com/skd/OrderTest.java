/**  
 * @Title: OrderTest.java
 * @Package com.skd
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月3日
 */
package com.skd;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skd.dao.OrderDao;
import com.skd.pojo.Order;
import com.skd.utils.PrimaryKeyUtil;

/**
 * ClassName: OrderTest 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月3日
 */
public class OrderTest {
	@Test
	public void run(){
		this.testGetOrder();
		
	}
	
	public void testInsertOrder(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
		Order order = new Order();
		order.setOrderId(PrimaryKeyUtil.createUserId());
		System.out.println(orderDao.insertSelective(order));
	}
	public void testGetOrder(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
		String[] orderId = new String[2];
		orderId[0] = "371720180604004307172452321";
		List<Order> dList = orderDao.getOrdersByID(orderId);
		for (Order order : dList) {
			
			System.out.println(order.getOrderId());
		}
	}

}
