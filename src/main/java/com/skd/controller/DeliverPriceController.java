/**  
 * @Title: DeliverPriceController.java
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skd.base.BaseController;
import com.skd.common.ResponseResult;
import com.skd.service.DeliverPriceService;

/**
 * ClassName: DeliverPriceController 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月27日
 */
@Controller("deliverPriceController")
@RequestMapping("/deliverPrice")
public class DeliverPriceController extends BaseController {
	Logger logger = LoggerFactory.getLogger(DeliverPriceController.class);
	
	@Autowired
	DeliverPriceService deliverPriceService;
	
	@RequestMapping(value = "getDeliverPrice",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult getDeliverPrice(
			@RequestParam(required = true)String token,
			String pageObject){
		ResponseResult responseResult = new ResponseResult();
		List<Map<String, Object>> data = deliverPriceService.getDeliverPrice(token, pageObject);
		responseResult.setData(data);
		return responseResult;
	}

}
