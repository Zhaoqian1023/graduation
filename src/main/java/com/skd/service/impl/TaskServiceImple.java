/**  
 * @Title: TaskServiceImple.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月1日
 */
package com.skd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skd.common.PageObject;
import com.skd.dao.OrderDao;
import com.skd.dao.ProductDao;
import com.skd.dao.TaskDao;
import com.skd.dao.UserDao;
import com.skd.pojo.Task;
import com.skd.pojo.User;
import com.skd.redis.RedisUtil;
import com.skd.service.TaskService;
import com.skd.utils.Constants;
import com.skd.utils.DateUtil;

/**
 * ClassName: TaskServiceImple 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月1日
 */
@Service("taskServiceImple")
public class TaskServiceImple implements TaskService {
	Logger logger = LoggerFactory.getLogger(TaskServiceImple.class);
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private RedisUtil redisUtil;

	/* (non-Javadoc)
	 * @see com.skd.service.TaskService#autoPublish(java.lang.String, java.util.List)
	 */
	public boolean autoPublish(String userId, List<String> orderIds) {
		List<Task> tasks = new ArrayList<Task>();
		User user = userDao.findUserById(userId);
		for (String orderId : orderIds) {
			Map<String, Object> order = orderDao.findById(orderId);
			Map<String, Object> product = productDao.findById(order.get("PRODUCT_ID").toString());
			Task task = new Task();
			task.setStatus(1);
			task.setPublishTime(DateUtil.getNowDate());
			task.setPublishUser(user.getUserId());
			task.setTitle(product.get("PRODUCT_NAME")==null?"":product.get("PRODUCT_NAME").toString());
			task.setAddr(user.getLocation());
			task.setPhone(user.getPhone());
			task.setLinkman(user.getRealName());
			task.setWorkload(Double.parseDouble(order.get("PRODUCT_COUNT").toString()));
			task.setPayMoney((int) (Double.parseDouble(order.get("PRODUCT_COUNT").toString())*20000));
			task.setPayType("任务");
			task.setContent(product.get("DESCRIPTION").toString());
			tasks.add(task);
		}
		return taskDao.insertBatch(tasks)>0?true:false;
	}

	/* (non-Javadoc)
	 * @see com.skd.service.TaskService#getTask(java.lang.String, com.skd.common.PageObject)
	 */
	public List<Map<String, Object>> getTask(String taskType, PageObject pObject) {
		String rule = "PUBLISH_TIME desc";
		Task task = new Task();
		task.setStatus(Integer.parseInt(taskType));
		return taskDao.findObjects(task, pObject, rule);
	}

	/* (non-Javadoc)
	 * @see com.skd.service.TaskService#receiveTask(java.lang.String, java.lang.String)
	 */
	public boolean receiveTask(String token, String taskId) {
		String userId = redisUtil.hget(Constants.Token_USER, token).toString();
		Task task = new Task();
		task.setStatus(3);
		task.setAcceptUser(userId);
		task.setId(Integer.parseInt(taskId));
		return taskDao.updateByPrimaryKeySelective(task)>0?true:false;
	}

	/* (non-Javadoc)
	 * @see com.skd.service.TaskService#getDetail(java.lang.String)
	 */
	public Map<String, Object> getDetail(String taskId) {
		Task task = new Task();
		task.setId(Integer.parseInt(taskId));
		return taskDao.findObjects(task, null, null).size()>0?taskDao.findObjects(task, null, null).get(0):null;
	}

}
