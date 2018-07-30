/**  
 * @Title: TaskController.java
 * @Package com.skd.controller
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月31日
 */
package com.skd.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.skd.base.BaseController;
import com.skd.common.PageObject;
import com.skd.common.ResponseResult;
import com.skd.service.TaskService;
import com.skd.utils.StringUtil;

/**
 * ClassName: TaskController 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月31日
 */
@Controller("taskController")
@RequestMapping("/task")
public class TaskController extends BaseController{
	Logger logger = LoggerFactory.getLogger(TaskController.class);
	@Autowired
	private TaskService taskService;
	
	/**
	 * 获取任务列表（待领取，按时间逆序）
	 * @Description: TODO
	 * @param @return   
	 * @return ResponseResult  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年6月3日
	 */
	@RequestMapping(value = "getTaskList",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult getTaskList(@RequestParam(required = true)String taskType,
			String pageObject){
		ResponseResult responseResult = new ResponseResult();
		if(StringUtil.isNotBlank(taskType)){
			PageObject pObject = new PageObject();
			if(StringUtil.isNotBlank(pageObject)){
				pObject = JSONObject.parseObject(pageObject, PageObject.class);
			}
			List<Map<String, Object>> data = taskService.getTask(taskType,pObject);
			responseResult.setData(data);
			return responseResult;
		}
		responseResult.setSuccess(false);
		responseResult.setMsg("查询参数错误");
		return responseResult;
	}
	@RequestMapping(value = "receiveTask",method = RequestMethod.POST)
	@ResponseBody
	public ResponseResult receiveTask(@RequestParam(required = true)String token,
			                         @RequestParam(required = true)String taskId){
		ResponseResult responseResult = new ResponseResult();
		if(StringUtil.isNotBlank(taskId)){
			boolean result = taskService.receiveTask(token,taskId);
			responseResult.setSuccess(result);
			if(!result){
				responseResult.setMsg("抢单失败");
			}
			return responseResult;
		}
		responseResult.setSuccess(false);
		responseResult.setMsg("请求参数缺失");
		return responseResult;
	}
	/**
	 * 查看任务详情
	 * @Description: TODO
	 * @param @param taskId
	 * @param @return   
	 * @return ResponseResult  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年6月6日
	 */
	@RequestMapping(value = "getTaskDetail",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult getTaskDetail(@RequestParam(required = true)String taskId){
		ResponseResult responseResult = new ResponseResult();
		if(StringUtil.isNotBlank(taskId)){
			Map<String, Object> data = taskService.getDetail(taskId);
			if(data != null){
				responseResult.setData(data);
				return responseResult;
			}
			responseResult.setSuccess(false);
			responseResult.setMsg("系统异常");
			return responseResult;
			
		}
		responseResult.setSuccess(false);
		responseResult.setMsg("请求参数缺失");
		return responseResult;
	}

	

}
