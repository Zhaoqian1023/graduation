/**  
 * @Title: ProductController.java
 * @Package com.skd.controller
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月26日
 */
package com.skd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.skd.base.BaseController;
import com.skd.common.PageObject;
import com.skd.common.ResponseResult;
import com.skd.pojo.ProductType;
import com.skd.service.ProductService;
import com.skd.utils.Constants;
import com.skd.utils.JSONUtil;
import com.skd.utils.StringUtil;

/**
 * ClassName: ProductController
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月26日
 */
@Controller("productController")
@RequestMapping("/product")
public class ProductController extends BaseController {
	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	/**
	 * 条件查询商品
	 * 
	 * @Description: TODO
	 * @param @param productType
	 * @param @param pageObject
	 * @param @param sort
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年5月11日
	 */
	@RequestMapping(value = "getProductsByParam", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult getProductsByParam(
			@RequestParam(required = true) String productType,
			@RequestParam(required = true) String pageObject,
			String sort) {
		ResponseResult responseResult = new ResponseResult();
		if (StringUtil.isNotBlank(productType) && StringUtil.isNotBlank(pageObject)) {
			List<Map<String, Object>> data = null;
			ProductType pType = new ProductType();
			PageObject pObject = new PageObject();
			pType = JSONObject.parseObject(productType, ProductType.class);
			pObject = JSONObject.parseObject(pageObject,PageObject.class);
			if(StringUtil.isNotBlank(sort)){
				Map<String, String> paraMap = JSONUtil.jsonToStrMap(sort); 
				/**
				 * 综合
				 */
				if(Constants.PRODUCT_SHOW_TYPE_A.equals(paraMap.get("name"))){
					if(Integer.parseInt(paraMap.get("desc")) == 1){
						data = productService.getProductByQuality(pType, pObject, true);
					}else{
						data = productService.getProductByQuality(pType, pObject, false);
					}					
				}
				/**
				 * 价格
				 */
				if(Constants.PRODUCT_SHOW_TYPE_B.equals(paraMap.get("name"))){
					if(Integer.parseInt(paraMap.get("desc")) == 1){
						data = productService.getProductByPrice(pType, pObject, true);
					}else{
						data = productService.getProductByPrice(pType, pObject, false);
					}						
				}
				/**
				 * 销量
				 */
				if(Constants.PRODUCT_SHOW_TYPE_C.equals(paraMap.get("name"))){
					if(Integer.parseInt(paraMap.get("desc")) == 1){
						data = productService.getProductBySales(pType, pObject, true);
					}else{
						data = productService.getProductBySales(pType, pObject, false);
					}						
				}
				
			}else{
				/**
				 * 根据商品种类查询
				 */
				data = productService.getProduct(pType,pObject);
			}
			responseResult.setData(data);
			return responseResult;
		}
		responseResult.setMsg("参数确实");
		responseResult.setSuccess(false);
		return responseResult;
	}

	/**
	 * 添加商品（发布商品）
	 * 
	 * @Description: TODO
	 * @param @param token
	 * @param @param productInfo
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年5月9日
	 */
	@RequestMapping(value = "addProduct", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult addProduct(
			@RequestParam(required = true) String token,
			@RequestParam(required = true) String productInfo) {
		ResponseResult responseResult = new ResponseResult();
		if (StringUtil.isNotBlank(productInfo) && productInfo.length() >= 2) {
			if (productService.addProduct(token, productInfo)) {
				return responseResult;
			} else {
				responseResult.setMsg("添加失败");
				responseResult.setSuccess(false);
				return responseResult;
			}
		}
		responseResult.setMsg("参数缺失");
		responseResult.setSuccess(false);
		return responseResult;
	}

	/**
	 * @Description: 首页显示的精品产品列表
	 * @return ResponseResult
	 * @author zhaoqian
	 * @throws Exception
	 * @date 2018年4月27日
	 */

	@RequestMapping(value = "getProductList", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult getProductList() {
		ResponseResult responseResult = new ResponseResult();
		PageObject pageObject = new PageObject();
		ProductType productType = new ProductType();
		productType.setFirst(Constants.INDEX_PRODUCT_TYPE);
		List<Map<String, Object>> data = productService.getIndexList(pageObject, productType);
		if (data != null) {
			responseResult.setData(data);
			responseResult.setSuccess(true);
			responseResult.setStatus(1);
			responseResult.setMsg("处理成功");

		}
		return responseResult;

	}

	/**
	 * 
	 * @Description: 查看商品详情
	 * @param @param productId
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年4月28日
	 */
	@RequestMapping(value = "getProductDetail", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult getProductDetail(
			@RequestParam(required = true) String productId) {
		ResponseResult responseResult = new ResponseResult();
		if (StringUtil.isNotBlank(productId)) {
			Map<String, Object> data = new HashMap<String, Object>();
			data = productService.getDetail(productId);
			responseResult.setData(data);
			return responseResult;
		}
		responseResult.setSuccess(false);
		responseResult.setMsg("参数异常,无该商品ID");
		return responseResult;
	}

}
