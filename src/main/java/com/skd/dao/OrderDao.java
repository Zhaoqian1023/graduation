/**  
 * @Title: OrderDao.java
 * @Package com.skd.dao
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月3日
 */
package com.skd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skd.base.BaseDao;
import com.skd.pojo.Order;

/**
 * ClassName: OrderDao 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月3日
 */
public interface OrderDao extends BaseDao<Order>{
	
	/**
	 * 通过商品ID查询订单列表
	 * @Description: TODO
	 * @param @param orderId
	 * @return List<Order>  
	 * @author zhaoqian
	 * @date 2018年5月14日
	 */
	public List<Order> getOrdersByID(@Param("orderId") String[] orderId);
	
	

}
