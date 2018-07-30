/**  
 * @Title: ProductService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月27日
 */
package com.skd.service;

import java.util.List;
import java.util.Map;

import com.skd.common.PageObject;
import com.skd.pojo.ProductType;

/**
 * ClassName: ProductService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月27日
 */
public interface ProductService {
	
	/**
	 * 
	 * @Description: 主页展示精品推荐商品
	 * @param @param pageObject
	 * @param @param producttype
	 * @return List<Map<String,Object>>  
	 * @author zhaoqian
	 * @date 2018年4月28日
	 */
	public List<Map<String, Object>> getIndexList(PageObject pageObject,ProductType producttype);
	/**
	 * 
	 * @Description: 查询商品详情
	 * @param @param productId
	 * @return Map<String,Object>  
	 * @author zhaoqian
	 * @date 2018年4月28日
	 */
	public Map<String, Object> getDetail(String productId);
	/**公共接口，对应商品分类查询
	 * @Description: 
	 * @param @param productType
	 * @param @param pageObject
	 * @return List<Map<String,Object>>  
	 * @author zhaoqian
	 * @date 2018年4月27日
	 */
	public List<Map<String, Object>> getProduct(ProductType productType,PageObject pageObject);
	
	/**
	 * 
	 * @Description: 通过综合查询商品列表
	 * @param productType 类别
	 * @param @param pageObject 分页
	 * @param @param desc 排序
	 * @return List<Map<String,Object>>  
	 * @author zhaoqian
	 * @date 2018年4月27日
	 */
	public List<Map<String,Object>> getProductByQuality(ProductType producttype,PageObject pageObject,boolean desc);
	/**
	 * 
	 * @Description: 通过销量查询商品列表
	 * @param productType
	 * @param @param pageObject
	 * @param @param desc 逆序
	 * @return List<Map<String,Object>>  
	 * @author zhaoqian
	 * @date 2018年4月27日
	 */
	public List<Map<String, Object>> getProductBySales(ProductType producttype,PageObject pageObject,boolean desc);
	/**
	 * 
	 * @Description: 通过价格查询商品列表
	 * @param productType
	 * @param @param pageObject
	 * @param @param desc 逆序
	 * @return List<Map<String,Object>>  
	 * @author zhaoqian
	 * @date 2018年4月27日
	 */
	public List<Map<String, Object>> getProductByPrice(ProductType producttype,PageObject pageObject,boolean desc);
	/**
	 * 新增商品
	 * @Description: TODO
	 * @param @param token
	 * @param @param productInfo
	 * @param @return   
	 * @return boolean  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年5月10日
	 */
	public boolean addProduct(String token, String productInfo);
	
}
