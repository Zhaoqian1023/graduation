/**  
 * @Title: UserController.java
 * @Package com.skd.controller
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skd.base.BaseController;
import com.skd.service.UserService;

/**
 * ClassName: UserController 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */

@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController{
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	
	

}
