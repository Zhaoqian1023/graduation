/**  
 * @Title: ReceiveAddrServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月14日
 */
package com.skd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skd.dao.ReceiverAddrDao;
import com.skd.pojo.ReceiverAddr;
import com.skd.redis.RedisUtil;
import com.skd.service.ReceiverAddrService;
import com.skd.utils.Constants;

/**
 * ClassName: ReceiveAddrServiceImpl 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月14日
 */
@Service("receiveAddrServiceImpl")
public class ReceiverAddrServiceImpl implements ReceiverAddrService {
	
	Logger logger = LoggerFactory.getLogger(ReceiverAddrServiceImpl.class);
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private ReceiverAddrDao receiveAddrDao;
	/* (non-Javadoc)
	 * @see com.skd.service.ReceiveAddrService#getAddrByUser(java.lang.String)
	 */
	public List<Map<String, Object>> getAddrByUser(String token) {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		String userId = redisUtil.hget(Constants.Token_USER, token) == null ? null
				: redisUtil.hget(Constants.Token_USER, token).toString();
		if (userId != null) {
			ReceiverAddr receiverAddr = new ReceiverAddr();
			receiverAddr.setUserId(userId);
			data = receiveAddrDao.findObjects(receiverAddr, null, null);
		}
		return data;
	}

}
