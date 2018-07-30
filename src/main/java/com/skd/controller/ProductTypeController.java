/**  
 * @Title: ProductTypeController.java
 * @Package com.skd.controller
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
package com.skd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skd.base.BaseController;
import com.skd.common.ResponseResult;
import com.skd.service.ProductTypeService;

/**
 * ClassName: ProductTypeController 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
@Controller("productTypeController")
@RequestMapping("/productType")
public class ProductTypeController extends BaseController {
	
	Logger logger = LoggerFactory.getLogger(ProductTypeController.class);
	@Autowired
	private ProductTypeService productTypeService;
	/**
	 * 查询商品分类，参数为产品分类对象，非必须
	 * @Description: TODO
	 * @param @param productType
	 * @param @param pageObject
	 * @return ResponseResult  
	 * @author zhaoqian
	 * @date 2018年5月27日
	 */
	@RequestMapping(value = "getProductType",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult getProductType(String productType,String pageObject){
		ResponseResult responseResult = new ResponseResult();
		List<Map<String, Object>> data = productTypeService.getProductType(productType,pageObject);
		responseResult.setData(data);
		return responseResult;
	}
	

}
