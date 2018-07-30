/**  
 * @Title: TaskService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月31日
 */
package com.skd.service;

import java.util.List;
import java.util.Map;

import com.skd.common.PageObject;

/**
 * ClassName: TaskService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月31日
 */
public interface TaskService {
	/**
	 * 自动发布任务
	 * @Description: TODO
	 * @param @param userId
	 * @param @param orderIds
	 * @return boolean  
	 * @author zhaoqian
	 * @date 2018年5月31日
	 */
	public boolean autoPublish(String userId,List<String> orderIds);

	/**根据任务类型分页查询（默认时间倒序）
	 * @Description: TODO
	 * @param @param taskType
	 * @param @param pObject
	 * @param @return   
	 * @return List<Map<String,Object>>  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年6月3日
	 */
	public List<Map<String, Object>> getTask(String taskType, PageObject pObject);

	/**用户抢单
	 * @Description: TODO
	 * @param @param token
	 * @param @param taskId
	 * @param @return   
	 * @return boolean  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年6月4日
	 */
	public boolean receiveTask(String token, String taskId);

	/**
	 * 查看任务详情
	 * @Description: TODO
	 * @param @param taskId
	 * @return Map<String,Object>  
	 * @author zhaoqian
	 * @date 2018年6月6日
	 */
	public Map<String, Object> getDetail(String taskId);

}
