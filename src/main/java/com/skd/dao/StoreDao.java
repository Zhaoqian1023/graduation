/**  
 * @Title: StoreDao.java
 * @Package com.skd.dao
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月28日
 */
package com.skd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.skd.base.BaseDao;
import com.skd.common.PageObject;
import com.skd.pojo.Store;

/**
 * ClassName: StoreDao 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月28日
 */
public interface StoreDao extends BaseDao<Store> {
	
	public List<Store> getStores(@Param("store") Store store,@Param("pageobject") PageObject pageObject,
			@Param("rule") String rule);
    
}
