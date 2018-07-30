/**  
 * @Title: UserServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skd.dao.UserDao;
import com.skd.dao.UserRoleDao;
import com.skd.pojo.User;
import com.skd.pojo.UserRole;
import com.skd.redis.RedisUtil;
import com.skd.service.UserService;
import com.skd.utils.Constants;
import com.skd.utils.DateUtil;
import com.skd.utils.HashUtil;
import com.skd.utils.PrimaryKeyUtil;
import com.skd.utils.RandomUtil;
import com.skd.utils.TokenUtil;

/**
 * ClassName: UserServiceImpl 缓存机制说明：所有的查询结果都放进了缓存，也就是把MySQL查询的结果放到了redis中去，
 * 然后第二次发起该条查询时就可以从redis中去读取查询的结果，从而不与MySQL交互，从而达到优化的效果，
 * redis的查询速度之于MySQL的查询速度相当于 内存读写速度 /硬盘读写速度
 * 
 * @Cacheable("a")注解的意义就是把该方法的查询结果放到redis中去，下一次再发起查询就去redis中去取，存在redis中的数据的key就是a；
 * @CacheEvict(value={"a","b" ,allEntries=true)
 *                            的意思就是执行该方法后要清除redis中key名称为a,b的数据；
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private UserRoleDao userRoleDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skd.service.UserService#loginValid(com.skd.pojo.User)
	 */
	public Map<String, Object> loginCheck(User user) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String token = null;
		List<User> users = userDao.getUsers(user, null, null);
		if (users.size() > 0) {
			User realUser = users.get(0);
			if (null != realUser) {
				String msg = realUser.getUserId();
				token = TokenUtil.getToken(msg);
				dataMap.put("userId", msg);
				dataMap.put("token", token);
				Map<String,Object> redisData = new HashMap<String,Object>();
				redisData.put(token, msg);
				redisUtil.hmset(Constants.Token_USER, redisData, 7*24*60*60);
				/**
				 * 缓存查询权限 
				 */
				List<Map<String, Object>> userRole = userDao.getRoleInfo(user);
				Set<String> role = new HashSet<String>();
				for (Map<String,Object> map : userRole) {
					role.add(map.get("CONTENT").toString());
				}
				Map<String,Object> redisRole = new HashMap<String,Object>();
				redisRole.put(msg, role);
				redisUtil.hmset(Constants.USER_ROLE, redisRole);
				return dataMap;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skd.service.UserService#saveUser(com.skd.pojo.User)
	 */
	public String saveUser(User user) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.skd.service.UserService#register(java.lang.String,
	 * java.lang.String)
	 */
	public String register(String phone, String uPwd) {
		/**
		 * 用户注册逻辑 1、redis缓存中获取手机号及其验证码 2、创建User对象，将手机号及其默认密码 3、存储新用户对象，返回用户ID
		 */
		String userId = null;
		String temp = redisUtil.hget(Constants.REGISTER_REDIS_SMS, phone) == null ? null
				: redisUtil.hget(Constants.REGISTER_REDIS_SMS, phone)
						.toString();
		logger.info(temp+"-----短信验证码------");
		if (temp != null && uPwd.equals(temp)) {
			String hashPassword = HashUtil.hashMD5Base64(Constants.INITIAL_PWD);
			User user = new User();
			user.setUserName(Constants.USER_NAME);
			user.setPhone(phone);
			user.setUpwd(hashPassword);
			userId = PrimaryKeyUtil.createUserId();
			user.setUserId(userId);
			user.setRegisTime(DateUtil.getNowDate());
			user.setInviteCode(RandomUtil.genEasyPswd(6));
			user.setRegisType(Constants.REGIS_TYPE_PHONE);
			userDao.insertSelective(user);
			/**
			 * 添加默认角色，农乐角色
			 */
			UserRole userRole = new UserRole();
			userRole.setUserId(userId);
			userRole.setRoleId(Integer.parseInt(Constants.DEFAULT_USER_ROLE));
			userRoleDao.insertSelective(userRole);
			
		}
		return userId;
	}

	/* (non-Javadoc)
	 * @see com.skd.service.UserService#logout(java.lang.String)
	 */
	public boolean logout(String token) {
		redisUtil.hdel(Constants.Token_USER, token);
		return true;
	}

}
