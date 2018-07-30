/**  
 * @Title: AuthorityDao.java
 * @Package com.skd.dao
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
package com.skd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skd.base.BaseDao;
import com.skd.pojo.Authority;

/**
 * ClassName: AuthorityDao 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
public interface AuthorityDao extends BaseDao<Authority>{
	
	public List<Authority> getAuthorities(@Param("authority")Authority authority);
	
	

}
