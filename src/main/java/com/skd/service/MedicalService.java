/**  
 * @Title: MedicalService.java
 * @Package com.skd.service
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月6日
 */
package com.skd.service;

import java.util.Map;

/**
 * ClassName: MedicalService 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月6日
 */
public interface MedicalService {
	/**
	 * 诊断
	 * @Description: TODO
	 * @param @param imagePath
	 * @param @return   
	 * @return Map<String,Object>  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年6月6日
	 */
	public Map<String, Object> diagnosis(String imagePath);

}
