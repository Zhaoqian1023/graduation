/**  
 * @Title: AuthorityServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
package com.skd.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skd.dao.AuthorityDao;
import com.skd.pojo.Authority;
import com.skd.service.AuthorityService;

/**
 * ClassName: AuthorityServiceImpl 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月8日
 */
@Service("authorityServiceImpl")
public class AuthorityServiceImpl implements AuthorityService{
	Logger logger = LoggerFactory.getLogger(AuthorityServiceImpl.class);
	@Autowired
	private AuthorityDao authorityDao;

	/* (non-Javadoc)
	 * @see com.skd.service.AuthorityService#getAuthority(int)
	 */
	public Set<String> getAuthority(int type) {
		logger.info("----------"+type);
		Authority authority = new Authority();
		authority.setInterfaceType(type);
		List<Authority> data = new ArrayList<Authority>();
		Set<String> resultSet = new HashSet<String>();
		data = authorityDao.getAuthorities(authority);
		if(data.size() > 0){
			for (Authority obj : data) {
				resultSet.add(obj.getContent());
			}
		}
		return resultSet.size()>0?resultSet:null;
	}

}
