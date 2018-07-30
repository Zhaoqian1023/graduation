/**  
 * @Title: JSONUtil.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd.utils;

import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * ClassName: JSONUtil 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
public class JSONUtil {
	public static String toJSONString(Object paramMap) {
		return JSON.toJSONString(paramMap);
	}
	/**
	 * json字符串转化成map
	 * @Description: TODO
	 * @param @param mapString
	 * @return Map<?,?>  
	 * @author zhaoqian
	 * @date 2018年5月3日
	 */
	public static Map<?, ?> jsonToMap(String mapString) {
		return JSON.parseObject(mapString, Map.class);
	}
	
	/**
	 * 
	 * @Description: TODO
	 * @param @param mapString
	 * @return Map<String,String>  
	 * @author zhaoqian
	 * @date 2018年5月3日
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> jsonToStrMap(String mapString) {
		return JSON.parseObject(mapString, Map.class);
	}

}
