/**  
 * @Title: ObjectUtil.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月1日
 */
package com.skd.utils;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skd.pojo.User;

/**
 * ClassName: ObjectUtil 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月1日
 */
public class ObjectUtil {
	
	public static Logger logger = LoggerFactory.getLogger(ObjectUtil.class);
	/**
	 * 判断对象各个属性是否为null
	 * @Description: TODO
	 * @param @param obj
	 * @param @return
	 * @param @throws IllegalAccessException   
	 * @return boolean  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年6月2日
	 */
	public static boolean checkObjFieldIsNull(Object obj) throws IllegalAccessException {

	    boolean flag = false;
	    for(Field f : obj.getClass().getDeclaredFields()){
	        f.setAccessible(true);
	        logger.info(f.getName());
	        if(f.get(obj) == null){
	            flag = true;
	            return flag;
	        }
	    }
	    return flag;
	}
	
	/**
	 * 用户购买特色商品信息核对，要求用户地址信息非空
	 * 具体为：用户名，用户真实姓名，联系方式，所在区域，详细地址
	 * @Description: TODO
	 * @param @param obj
	 * @param @throws IllegalAccessException   
	 * @return boolean  
	 * @author zhaoqian
	 * @date 2018年6月3日
	 */
	public static boolean checkUserIsNull(User obj) throws IllegalAccessException {
	    boolean flag = false;
	    for(Field f : obj.getClass().getDeclaredFields()){
	        f.setAccessible(true);
	        logger.info(f.getName());
	        if((f.getName().equals("realName") && f.get(obj) == null ) ||
	        		(f.getName().equals("phone") && f.get(obj) == null ) ||
	        		(f.getName().equals("area") && f.get(obj) == null ) ||
	        		(f.getName().equals("location") && f.get(obj) == null ||
	        		(f.getName().equals("userName") && f.get(obj) == null ))){
	            flag = true;
	            return flag;
	        }
	    }
	    return flag;
	}
	
	public static void main(String[] args) {
		User user = new User();
		user.setUserId("222222");
		user.setRealName("zhaoqian");
		try {
			ObjectUtil.checkUserIsNull(user);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
