/**  
 * @Title: UserDao.java
 * @Package com.skd.dao
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.skd.base.BaseDao;
import com.skd.common.PageObject;
import com.skd.pojo.User;

/**
 * ClassName: UserDao 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */

public interface UserDao extends BaseDao<User> {
	
	/**
	 * @Description: 通过用户ID查询用户信息
	 * @param @param id
	 * @return User  
	 * @author zhaoqian
	 * @date 2018年4月25日
	 */
	public User findUserById(@Param("id")String id);
	
	/**
	 * 
	 * @Description: 获取用户集合，条件查询
	 * @param @param user
	 * @param @param pageObject
	 * @param @param rule
	 * @return List<User>  
	 * @author zhaoqian
	 * @date 2018年4月30日
	 */
	public List<User> getUsers(@Param("user")User user,@Param("pageobject") PageObject pageObject,
			@Param("rule") String rule);
	
	/**
	 * 获取用户的相关信息（权限）
	 * @Description: TODO
	 * @param @param user
	 * @return List<Map<String,Object>>  
	 * @author zhaoqian
	 * @date 2018年5月8日
	 */
	public List<Map<String, Object>> getRoleInfo(@Param("user")User user);
	
}
