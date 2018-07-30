/**  
 * @Title: ProductDao.java
 * @Package com.skd.dao
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月26日
 */
package com.skd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.skd.base.BaseDao;
import com.skd.common.PageObject;
import com.skd.pojo.Product;
import com.skd.pojo.ProductType;

/**
 * ClassName: ProductDao
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月26日
 */
public interface ProductDao extends BaseDao<Product> {
	
	/**
	 * 根据商品类别，分页查询
	 * @Description: TODO
	 * @param @param pageObject
	 * @param @param productType
	 * @param rule
	 * @return List<Map<String,Object>>  
	 * @author zhaoqian
	 * @date 2018年5月11日
	 */
	public List<Map<String, Object>> getProductByTypeAndPage(@Param("pageobject") PageObject pageObject,
															@Param("productType") ProductType productType,
															@Param("rule") String rule);
	
	/**
	 * 通过商品ID获取商品集合
	 * @Description: TODO
	 * @param @param productId
	 * @return List<Product>  
	 * @author zhaoqian
	 * @date 2018年5月3日
	 */
	public List<Product> getList(@Param("productId")String[] productId);
	
	/**
	 * 购物车商品分类
	 * @Description: TODO
	 * @param @param productId
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年5月2日
	 */
	public List<Map<String, Object>> getShoppingProduct(@Param("productId")String[] productId);
	
	/**
	 * 统计商品已出售情况
	 * @Description: TODO
	 * @param @param productId
	 * @return int  
	 * @author zhaoqian
	 * @date 2018年4月28日
	 */
	public int statisticsSale(@Param("productid") String productId);
	
	/**
	 * 
	 * @Description: 获取首页产品列表
	 * @param @param pageObject
	 * @return List<Map<String,Object>>  
	 * @author zhaoqian
	 * @date 2018年4月28日
	 */
	public List<Map<String, Object>> getIndexData(@Param("pageobject") PageObject pageObject,@Param("productType") ProductType productType);
	/**
	 * @Description: 获取商品数量
	 * @return int
	 * @author zhaoqian
	 * @date 2018年4月26日
	 */
	public int getCount(@Param("product") Product product);

	/**
	 * 
	 * @Description: 分页查询商品
	 * @param @param product
	 * @param @param pageObject
	 * @param @param rule 排序规则字段
	 * @return List<Product>
	 * @author zhaoqian
	 * @date 2018年4月27日
	 */
	public List<Product> getProducts(@Param("product") Product product,
			@Param("pageobject") PageObject pageObject,
			@Param("rule") String rule);

	
	/**
	 * @Description: 添加商品
	 * @param @param product
	 * @return int
	 * @author zhaoqian
	 * @date 2018年4月27日
	 */
	public int addProduct(@Param("product") Product product);

	/**
	 * 
	 * @Description: 选择添加商品（动态部分字段）
	 * @param @param product
	 * @author zhaoqian
	 * @date 2018年4月27日
	 */
	public int addProductSelective(@Param("product") Product product);

	/**
	 * 
	 * @Description: 更新商品
	 * @param @param product
	 * @return int
	 * @author zhaoqian
	 * @date 2018年4月27日
	 */
	public int updateProductByKey(@Param("product") Product product);

	/**
	 * @Description: 更新商品（动态部分字段）
	 * @param @param product
	 * @return int
	 * @author zhaoqian
	 * @date 2018年4月27日
	 */
	public int updateProductSelectiveByKey(@Param("product") Product product);

}
