/**  
 * @Title: ProductTypeDao.java
 * @Package com.skd.dao
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
package com.skd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skd.base.BaseDao;
import com.skd.common.PageObject;
import com.skd.pojo.ProductType;

/**
 * ClassName: ProductTypeDao 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
public interface ProductTypeDao extends BaseDao<ProductType>{
	public List<ProductType> findProductType(@Param("productType") ProductType productType,
			@Param("pageobject") PageObject pageObject,
			@Param("rule") String rule);

}
