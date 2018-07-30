/**  
 * @Title: ShoppingController.java
 * @Package com.skd.controller
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
package com.skd.controller;

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
import com.skd.service.ShoppingService;
import com.skd.utils.StringUtil;

/**
 * ClassName: ShoppingController
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
@Controller("shoppingController")
@RequestMapping("/shopping")
public class ShoppingController extends BaseController {

	Logger logger = LoggerFactory.getLogger(ShoppingController.class);
	@Autowired
	private ShoppingService shoppingService;

	/**
	 * @Description: 添加购物车
	 * @param @param token
	 * @param @param productId
	 * @param @param count
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年5月1日
	 */
	@RequestMapping(value = "addShopping", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult addShopping(
			@RequestParam(required = true) String token,
			@RequestParam(required = true) String productId,
			@RequestParam(required = true) String count) {
		ResponseResult responseResult = new ResponseResult();

		if (StringUtil.isNotBlank(productId) && StringUtil.isNotBlank(count)) {
			if (shoppingService.addShopping(token, productId, count)) {
				return responseResult;
			} else {
				responseResult.setSuccess(false);
				responseResult.setMsg("用户未登录");
				return responseResult;
			}
		}
		responseResult.setSuccess(false);
		responseResult.setMsg("系统异常");
		return responseResult;
	}

	/**
	 * 清空购物车
	 * 
	 * @Description: TODO
	 * @param @param token
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年5月2日
	 */
	@RequestMapping(value = "clearShopping", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult clearShopping(
			@RequestParam(required = true) String token) {
		ResponseResult responseResult = new ResponseResult();
		if (shoppingService.clearShopping(token)) {
			return responseResult;
		}
		responseResult.setSuccess(false);
		responseResult.setMsg("请求异常");
		return responseResult;
	}

	/**
	 * 删除购物车中指定商品，可以多选
	 * 
	 * @Description: TODO
	 * @param @param token
	 * @param @param productId
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年5月2日
	 */
	@RequestMapping(value = "delShopping", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult delShopping(
			@RequestParam(required = true) String token,
			@RequestParam(required = true) String... productId) {
		ResponseResult responseResult = new ResponseResult();
		if (productId != null) {
			if (productId.length > 0) {
				if (shoppingService.delShopping(token, productId)) {
					return responseResult;
				}
			}
		}
		responseResult.setSuccess(false);
		responseResult.setMsg("请求异常");
		return responseResult;
	}

	/**
	 * 查看购物车
	 * 
	 * @Description: TODO
	 * @param @param token
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年5月2日
	 */
	@RequestMapping(value = "showShopping", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult showShopping(
			@RequestParam(required = true) String token) {
		ResponseResult responseResult = new ResponseResult();
		responseResult.setData(shoppingService.getShopping(token));
		return responseResult;
	}

}
