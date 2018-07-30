/**  
 * @Title: LoginFilter.java
 * @Package com.skd.filter
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
package com.skd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: LoginFilter
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
@SuppressWarnings("serial")
public class LoginFilter extends HttpServlet implements Filter {
	Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private String uri = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		request = (HttpServletRequest) req;
		response = (HttpServletResponse) resp;
		uri = request.getServletPath();
		
		if (uri.equals("")) {
			uri += "/";
		}
		
		

	}

}
