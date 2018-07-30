/**  
 * @Title: ProductTypeServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
package com.skd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.skd.common.PageObject;
import com.skd.dao.ProductTypeDao;
import com.skd.pojo.ProductType;
import com.skd.service.ProductTypeService;

/**
 * ClassName: ProductTypeServiceImpl 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
@Service("productTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService{
	Logger logger = LoggerFactory.getLogger(ProductTypeServiceImpl.class);
	@Autowired
	private ProductTypeDao productTypeDao;
	
	/* (non-Javadoc)
	 * @see com.skd.service.ProductTypeService#getProductType(java.lang.String)
	 */
	public List<Map<String, Object>> getProductType(String productType,String pageObject) {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		ProductType pType = null;
		PageObject pObject = null;
		if(productType != null){
			pType = JSONObject.parseObject(productType, ProductType.class);
		}
		if(pageObject != null){
			pObject = JSONObject.parseObject(pageObject,PageObject.class);
		}
		result = productTypeDao.findObjects(pType, pObject, null);
		return result;
	}

}
