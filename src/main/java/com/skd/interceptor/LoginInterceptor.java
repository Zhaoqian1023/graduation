/**  
 * @Title: LoginInterceptor.java
 * @Package com.skd.interceptor
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月10日
 */
package com.skd.interceptor;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.skd.common.ResponseResult;
import com.skd.redis.RedisUtil;
import com.skd.utils.Constants;
import com.skd.utils.StampUtil;
import com.skd.utils.StringUtil;

/**
 * ClassName: LoginInterceptor 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月10日
 */
public class LoginInterceptor implements HandlerInterceptor {
	
	Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	@Autowired
	private RedisUtil redisUtil;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String uri = null;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		request = arg0;
		response = arg1;
		uri = request.getServletPath();//获取项目访问真实路径
		
		if (uri.equals("")) {
			uri += "/";
		}
		logger.info(uri+"======uri======");
		ResponseResult responseResult = new ResponseResult();
		
		/**
		 * 请求超时反馈
		 */
		if (StringUtil.isBlank(request.getParameter("stamp"))||!StampUtil.checkStamp(request.getParameter("stamp"))) {
			responseResult.setSuccess(false);
			responseResult.setMsg("Request Timeout");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			PrintWriter pWriter = response.getWriter();
			pWriter.write(JSONObject.toJSONString(responseResult));
			pWriter.flush();
			pWriter.close();
			return false;
		}
		
		/**
		 * 判断当前用户token合法性
		 */
		String action = uri;
		String token = request.getParameter("token") == null?"":request.getParameter("token");
		String defaultRole = Constants.PUBLIC_ROLE;
		/**
		 * 查询系统公共权限
		 */
		Set<Object> data = redisUtil.sGet(defaultRole) == null?null:redisUtil.sGet(defaultRole);
		Set<String> realAction = new HashSet<String>();//默认页面
		if(data != null){
			for(Object obj:data){
				realAction.add(obj.toString());
			}
		}
		/**
		 * 查询当前用户权限
		 */
		String userId = redisUtil.hget(Constants.Token_USER, token) == null ? null
				: redisUtil.hget(Constants.Token_USER, token).toString();
		logger.info(userId + "====userId====");
		if(userId != null){
			Set<Object> set = redisUtil.hget(Constants.USER_ROLE, userId) == null ? null
					: (Set<Object>) redisUtil.hget(Constants.USER_ROLE, userId);
			if(set != null){
				for(Object obj:set){
					realAction.add(obj.toString());
				}
			}
		}
		logger.info(realAction.toString() + "====realAction====");
		
		
		/**
		 * 权限审核
		 */
		if(realAction.contains(action)){
			return true;
		}else{
			responseResult.setSuccess(false);
			responseResult.setMsg("Service Refuse,No Authority");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			PrintWriter pWriter = response.getWriter();
			pWriter.write(JSONObject.toJSONString(responseResult));
			pWriter.flush();
			pWriter.close();
			return false;
		}
	}

}
