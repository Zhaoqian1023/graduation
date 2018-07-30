/**  
 * @Title: ProductTest.java
 * @Package com.skd
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月28日
 */
package com.skd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skd.common.PageObject;
import com.skd.dao.ProductDao;
import com.skd.pojo.ProductType;
import com.skd.service.ProductService;
import com.skd.utils.JSONUtil;

/**
 * ClassName: ProductTest 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月28日
 */
public class ProductTest {
	@Test
	public void run(){
		testQueryProductByQuality();
	}
	public void testQueryById(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		ProductDao productDao = (ProductDao) ctx.getBean("productDao");
		Map<String, Object> data = productDao.findById("3714201804280011");
		System.out.println(data);
	}
	public void testStatisticsSale(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		ProductDao productDao = (ProductDao) ctx.getBean("productDao");
		System.out.print(productDao.statisticsSale("3714201804280011"));
	}
	public void testGetShoppingProduct(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		ProductDao productDao = (ProductDao) ctx.getBean("productDao");
		String[] temp = {"3714201804281111","3714201804280011","3714201804281126"};
		List<Map<String, Object>> data = productDao.getShoppingProduct(temp);
		for (Map<String, Object> v :data) {
			System.err.println(v.toString());
			
		}
	}
	public void testAddProduct(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		ProductService productService = (ProductService) ctx.getBean("productServiceImpl");
		String token = "W0JANGE3YjU3M2Y.";
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("prouctName", "特色产品，秸秆还田");
		temp.put("priceNow", "1222");
		temp.put("status", "1");
		temp.put("priceBefore", "1567");
		temp.put("description", "该敢拼为公司特色产品，欢迎使用！！！");
		temp.put("productModel", "10000/亩");
		temp.put("storage", "23");
		temp.put("productType", "1");
		System.out.println(JSONUtil.toJSONString(temp));
		if(productService.addProduct(token, JSONUtil.toJSONString(temp))){
			System.out.print("success");
		}else{
			System.out.print("error");
		}
	}
	public void testQueryProduct(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		ProductService productService = (ProductService) ctx.getBean("productServiceImpl");
		ProductType producttype = new ProductType();
		producttype.setFirst("特色商品");
		PageObject pageObject = new PageObject();
		List<Map<String, Object>> dataList = productService.getProduct(producttype, pageObject);
		for (Map<String, Object> map : dataList) {
			System.out.println(map.toString());
		}
	}
	public void testQueryProductByQuality(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		ProductService productService = (ProductService) ctx.getBean("productServiceImpl");
		ProductType producttype = new ProductType();
		producttype.setFirst("特色商品");
		PageObject pageObject = new PageObject();
		List<Map<String, Object>> dataList = productService.getProductByQuality(producttype, pageObject, true);
		for (Map<String, Object> map : dataList) {
			System.out.println(map.toString());
		}
	}
	public void testQueryProductBySales(){
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("spring/spring-source.xml");
		ProductService productService = (ProductService) ctx.getBean("productServiceImpl");
		ProductType producttype = new ProductType();
		producttype.setFirst("特色商品");
		PageObject pageObject = new PageObject();
		List<Map<String, Object>> dataList = productService.getProductBySales(producttype, pageObject, false);
		for (Map<String, Object> map : dataList) {
			System.out.println(map.toString());
		}
	}

}
