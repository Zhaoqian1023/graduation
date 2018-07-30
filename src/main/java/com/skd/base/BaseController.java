/**  
 * @Title: BaseController.java
 * @Package com.skd.base
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.skd.pojo.User;

/**
 * ClassName: BaseController 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
public class BaseController {
	/**
	 * 取得session
	 * @param request
	 * @param key
	 * @return
	 */
    public Object getSession(HttpServletRequest request,String key) {
        return request.getSession().getAttribute(key);
    }

    /**
     * 设置session
     * @param request
     * @param key
     * @param value
     */
    public void setSession(HttpServletRequest request,String key, Object value) {
    	request.getSession().setAttribute(key, value);
    }

    /**
     * 移除session
     * @param request
     * @param key
     */
    public void removeSession(HttpServletRequest request,String key) {
    	HttpSession session = request.getSession();
    	if(null != session.getAttribute(key)){
    		session.removeAttribute(key);
    	}
    }
    
    public User getCurrentUser(HttpSession session){
    	return (User)session.getAttribute("currentUser");
    }
    
    

}
