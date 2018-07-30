/**  
 * @Title: ShoppingService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
package com.skd.service;

import java.util.List;
import java.util.Map;

/**
 * ClassName: ShoppingService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
public interface ShoppingService {
	/**
	 * 
	 * @Description: 添加购物车
	 * @param @param token
	 * @param @param productId
	 * @param @param count
	 * @return boolean  
	 * @author zhaoqian
	 * @date 2018年5月1日
	 */
	public boolean addShopping(String token,String productId, String count);

	/**清空购物车
	 * @Description: TODO
	 * @param @param token   
	 * @author zhaoqian
	 * @date 2018年5月2日
	 */
	public boolean clearShopping(String token);

	/**
	 * 删除指定购物车
	 * @Description: TODO
	 * @param @param token
	 * @param @param productId
	 * @return boolean  
	 * @author zhaoqian
	 * @date 2018年5月2日
	 */
	public boolean delShopping(String token, String[] productId);
	/**
	 * 获取购物车信息
	 * @Description: TODO
	 * @param @param token
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年5月2日
	 */
	public List<Map<String, Object>> getShopping(String token);

}
