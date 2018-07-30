/**  
 * @Title: StoreController.java
 * @Package com.skd.controller
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月4日
 */
package com.skd.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skd.base.BaseController;
import com.skd.common.ResponseResult;
import com.skd.service.StoreService;
import com.skd.utils.StringUtil;

/**
 * ClassName: StoreController 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月4日
 */
@Controller("storeController")
@RequestMapping("/store")
public class StoreController extends BaseController{
	Logger logger = LoggerFactory.getLogger(StoreController.class);
	@Autowired
	private StoreService storeService;
	/**
	 * 进入店铺，查看店铺中商品
	 * @Description: TODO
	 * @param @param storeId
	 * @param @return   
	 * @return ResponseResult  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年6月4日
	 */
	@RequestMapping(value = "enterStore",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult enterStore(String token,
			@RequestParam(required = true)String storeId){
		ResponseResult responseResult = new ResponseResult();
		if(StringUtil.isNotBlank(storeId)){
			Map<String, Object> data = storeService.getProducts(token,storeId);
			if(data != null && data.size() >0){
				responseResult.setData(data);
				return responseResult;
			}
			responseResult.setSuccess(false);
			responseResult.setMsg("系统异常");
		}
		responseResult.setSuccess(false);
		responseResult.setMsg("参数缺失");
		return responseResult;
	}

}
