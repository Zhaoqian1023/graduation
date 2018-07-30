/**  
 * @Title: AuthorityService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
package com.skd.service;

import java.util.Set;

/**
 * ClassName: AuthorityService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
public interface AuthorityService {
	/**
	 * 根据权限类别查询权限列表
	 * @Description: TODO
	 * @param @param type
	 * @return Set<String>  
	 * @author zhaoqian
	 * @date 2018年5月8日
	 */
	public Set<String> getAuthority(int type);
	

}
