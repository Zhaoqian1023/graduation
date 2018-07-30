/**  
 * @Title: BaseDao.java
 * @Package com.skd.dao
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.skd.common.PageObject;

/**
 * ClassName: BaseDao 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
public interface BaseDao<T extends Serializable> {
	/**
	 * @Description: 查询全部对象数量
	 * @return 返回具体数量
	 * @author zhaoqian
	 * @date 2018年4月25日
	 */
	int getRowCounts(@Param(value="entity") T entity);
	/**
	 * 
	 * @Description: 分页获取结果集，分页查询
	 * @param @param pageObj 页数
	 * @return List<Map<String,Object>>  本页的结果集
	 * @author zhaoqian
	 * @date 2018年4月25日
	 */
	List<Map<String,Object>> findObjects(@Param(value = "entity") T entity,@Param(value = "pageobject") PageObject pageObject,@Param("rule") String rule);
    /**
     * 
     * @Description: 新增对象
     * @param @param entity
     * @return int  
     * @author zhaoqian
     * @date 2018年4月25日
     */
	
	int insert(T entity);
	/**
	 * 
	 * @Description: 选择插入，根据传入的对象属性
	 * @param @param entity
	 * @param @return   
	 * @return int  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年4月25日
	 */
	int insertSelective(T entity);
	/**
	 * 选择更新
	 * @Description: 更新对象
	 * @param @param entity
	 * @return int  
	 * @author zhaoqian
	 * @date 2018年4月25日
	 */
    int updateByPrimaryKeySelective(T entity);
    /**
     * 全部更新
     * @Description: TODO
     * @param @param entity
     * @return int  
     * @author zhaoqian
     * @date 2018年5月14日
     */
    int updateByPrimaryKey(T entity);
    /**
     * @Description: 通过ID查询数据
     * @param @param id
     * @return Map<String,Object> 单个对象键值形式  
     * @author zhaoqian
     * @date 2018年4月25日
     */
    Map<String,Object> findById(@Param (value="id") String id);
	
    /**
	 * 根据id执行删除动作，底层执行更新操作，修改其标识位0
	 * @param prjId
	 * @return
	 */
    int deleteByPrimaryKey(@Param (value="id") String id);

}
