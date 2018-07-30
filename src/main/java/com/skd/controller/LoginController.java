/**  
 * @Title: LoginController.java
 * @Package com.skd.controller
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月29日
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
import com.skd.pojo.User;
import com.skd.service.SmsService;
import com.skd.service.UserService;
import com.skd.utils.HashUtil;
import com.skd.utils.StringUtil;

/**
 * ClassName: LoginController
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月29日
 */
@Controller("loginController")
@RequestMapping("/login")
public class LoginController extends BaseController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private SmsService smsService;

	/**
	 * 用户名/手机、密码登录验证
	 * 
	 * @Description:
	 * @param @param uId
	 * @param @param uPwd
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年4月29日
	 */
	@RequestMapping(value = "toLogin", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult toLogin(@RequestParam(required = true) String uId,
			@RequestParam(required = true) String uPwd) {
		ResponseResult responseResult = new ResponseResult();
		if (StringUtil.isNotBlank(uId) && StringUtil.isNotBlank(uPwd)) {
			String hashPassword = HashUtil.hashMD5Base64(uPwd);
			User user = new User();
			if (uId.length() > 11) {
				user.setUserId(uId);// 通过用户账号登录
			} else {
				user.setPhone(uId);// 通过手机号登录
			}
			user.setUpwd(hashPassword);
			Map<String, Object> data = userService.loginCheck(user);
			if (data != null && data.get("token") != null
					&& data.get("userId") != null) {
				responseResult.setData(data);
				return responseResult;
			}
		}
		responseResult.setSuccess(false);
		responseResult.setMsg("登录校验未通过");
		return responseResult;
	}

	/**
	 * 短信验证
	 * 
	 * @Description: TODO
	 * @param @param phone
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年5月1日
	 */
	@RequestMapping(value = "checkSMS", method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult checkSMS(@RequestParam(required = true) String phone) {
		ResponseResult responseResult = new ResponseResult();
		if (StringUtil.isNotBlank(phone)) {
			String key = smsService.chechSMS(phone);
			if (key != null) {
				responseResult.setData(key);
				return responseResult;
			}
		}
		responseResult.setMsg("该手机号已注册");
		responseResult.setSuccess(false);
		return responseResult;
	}

	/**
	 * 用户注册(通过手机)
	 * 
	 * @Description:
	 * @param @param phone
	 * @param @param uPwd
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年4月29日
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult register(@RequestParam(required = true) String phone,
			@RequestParam(required = true) String uPwd) {
		ResponseResult responseResult = new ResponseResult();
		String uId = null;
		logger.info("====="+phone+"  "+uPwd);
		if (StringUtil.isNotBlank(phone) && StringUtil.isNotBlank(uPwd)) {
			uId = userService.register(phone, uPwd);
		}
		if (uId != null) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("uId", uId);
			responseResult.setData(data);
		} else {
			responseResult.setSuccess(false);
			responseResult.setMsg("用户注册失败");
		}
		return responseResult;
	}

	/**
	 * 退出登录
	 * 
	 * @Description:
	 * @param @param token
	 * @return ResponseResult
	 * @author zhaoqian
	 * @date 2018年5月2日
	 */
	@RequestMapping(value = "logOut", method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult logout(@RequestParam(required = true) String token) {
		ResponseResult responseResult = new ResponseResult();
		if (userService.logout(token)) {
			return responseResult;
		}
		responseResult.setMsg("请求参数异常");
		responseResult.setSuccess(false);
		return responseResult;
	}

}
