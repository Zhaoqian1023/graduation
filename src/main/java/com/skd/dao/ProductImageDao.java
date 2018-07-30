/**  
 * @Title: ProductImageDao.java
 * @Package com.skd.dao
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月28日
 */
package com.skd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.skd.base.BaseDao;
import com.skd.pojo.ProductImage;

/**
 * ClassName: ProductImageDao 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月28日
 */
public interface ProductImageDao extends BaseDao<ProductImage>{
	/**
	 * 
	 * @Description: 通过商品id获取商品相关图片
	 * @param @param pId
	 * @param @param imageType
	 * @return List<Map<String,Object>>  照片URL地址
	 * @author zhaoqian
	 * @date 2018年4月28日
	 */
	public List<Map<String, Object>> getImagesByProduct(@Param("pid")String pId,@Param("imagetype")int imageType); 

}
