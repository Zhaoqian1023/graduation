/**  
 * @Title: TaskDao.java
 * @Package com.skd.dao
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月28日
 */
package com.skd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skd.base.BaseDao;
import com.skd.pojo.Task;

/**
 * ClassName: TaskDao 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月28日
 */
public interface TaskDao extends BaseDao<Task> {
	/**
	 * 批量插入
	 * @Description: TODO
	 * @param @param tasks
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年6月1日
	 */
	public int insertBatch(@Param("tasks")List<Task> tasks);

}
