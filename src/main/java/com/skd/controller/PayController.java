/**  
 * @Title: PayController.java
 * @Package com.skd.controller
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月13日
 */
package com.skd.controller;

import java.util.HashMap;
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
import com.skd.common.ResponseResult;
import com.skd.service.PayService;
import com.skd.utils.StringUtil;

/**
 * ClassName: PayController 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月13日
 */
@Controller("payController")
@RequestMapping("/pay")
public class PayController extends BaseController{
	Logger logger = LoggerFactory.getLogger(PayController.class);
	@Autowired
	private PayService payService;
	
	/**
	 * 新建支付订单
	 * @Description: TODO
	 * @param @param token
	 * @param @param payType
	 * @param @param orderIds
	 * @return ResponseResult  
	 * @author zhaoqian
	 * @date 2018年5月13日
	 */
	@RequestMapping(value = "createPays",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult createPays(@RequestParam(required = true)String token,
			@RequestParam(required = true)String payType,
			@RequestParam(required = true)String... orderIds){
		ResponseResult responseResult = new ResponseResult();
		logger.info("token----:"+token+"payType----:"+payType+"orderIds----:"+orderIds.toString()+"  ------"+orderIds[0]);
		if(StringUtil.isNotBlank(payType) && orderIds.length>0){
			Map<String, Object> data = new HashMap<String, Object>();
			data = payService.createPay(token,payType,orderIds);
			logger.info(JSONObject.toJSONString(data)+"---------------");
			if(data != null && data.size()>0){
				
				responseResult.setData(data);
				return responseResult;
			}
			responseResult.setSuccess(false);
			responseResult.setMsg("付款失败,用户信息不完善");
			return responseResult;
		}
		responseResult.setSuccess(false);
		responseResult.setMsg("付款请求参数缺失");
		return responseResult;
	}
	

}
