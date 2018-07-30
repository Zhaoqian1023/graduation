/**  
 * @Title: TaskPublishJob.java
 * @Package com.skd.quartz
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月28日
 */
package com.skd.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: TaskPublishJob 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月28日
 */
public class TaskPublishJob {
	Logger logger = LoggerFactory.getLogger(TaskPublishJob.class);
	
	public void runStart(){
		logger.info("TaskPublishJob-----发布任务定时执行----------");
	}

}
