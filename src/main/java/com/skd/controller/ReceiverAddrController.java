/**  
 * @Title: ReceiverAddrController.java
 * @Package com.skd.controller
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月14日
 */
package com.skd.controller;

import java.util.ArrayList;
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
import com.skd.service.ReceiverAddrService;

/**
 * ClassName: ReceiverAddrController 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月14日
 */
@Controller("receiverAddrController")
@RequestMapping("/receiverAddr")
public class ReceiverAddrController extends BaseController{
	
	Logger logger = LoggerFactory.getLogger(ReceiverAddrController.class);
	
	@Autowired
	private ReceiverAddrService receiverAddrService;
	
	/**
	 * 获取用户收件地址
	 * @Description: TODO
	 * @param @param token
	 * @return ResponseResult  
	 * @author zhaoqian
	 * @date 2018年5月14日
	 */
	@RequestMapping(value = "getAddrByUser",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult getAddrByUser(@RequestParam(required = true)String token){
		ResponseResult responseResult = new ResponseResult();
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		data = receiverAddrService.getAddrByUser(token);
		if(data.size()>0){
			responseResult.setData(data);
			return responseResult;
		}
		responseResult.setMsg("获取收货地址失败");
		responseResult.setSuccess(false);
		return responseResult;
	}

}
