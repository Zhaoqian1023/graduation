/**  
 * @Title: OrderController.java
 * @Package com.skd.controller
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月3日
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

import com.skd.base.BaseController;
import com.skd.common.ResponseResult;
import com.skd.service.OrderService;
import com.skd.utils.StringUtil;

/**
 * ClassName: OrderController
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月3日
 */
@Controller("orderController")
@RequestMapping("/order")
public class OrderController extends BaseController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	OrderService orderService;

	/**
	 * 创建订单
	 * @Description: TODO
	 * @param @param token
	 * @param @param productInfo 商品信息，json数组
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年5月3日
	 */
	@RequestMapping(value="createOrder",method=RequestMethod.POST)
	@ResponseBody
	public ResponseResult createOrder(
			@RequestParam(required = true) String token,
			@RequestParam(required = true) String productMap,
			@RequestParam(required = true) String deliverMap) {
		ResponseResult responseResult = new ResponseResult();
		if (StringUtil.isNotBlank(productMap) && productMap.length() > 2
				&& deliverMap.length() > 2) {
			logger.info("-----"+token);
			logger.info("productMap-----"+productMap+",deliverMap-------"+deliverMap);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap = orderService.createOrder(token, productMap,deliverMap);
			if(resultMap.size()>0){
				responseResult.setData(resultMap);
			}else{
				responseResult.setSuccess(false);
				responseResult.setMsg("下单失败");
			}
			return responseResult;
		}
		responseResult.setSuccess(false);
		responseResult.setMsg("请求参数异常");
		return responseResult;
	}

}
