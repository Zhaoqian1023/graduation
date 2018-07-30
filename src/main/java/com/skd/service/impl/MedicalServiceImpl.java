/**  
 * @Title: MedicalServiceImpl.java
 * @Package com.skd.service.impl
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月6日
 */
package com.skd.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.skd.service.MedicalService;
import com.skd.utils.FileUtil;
import com.skd.utils.RunBatUtil;
import com.skd.utils.StringUtil;

/**
 * ClassName: MedicalServiceImpl 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月6日
 */
@Service("medicalServiceImpl")
public class MedicalServiceImpl implements MedicalService {
	Logger logger = LoggerFactory.getLogger(MedicalServiceImpl.class);

	/* (non-Javadoc)
	 * @see com.skd.service.MedicalService#diagnosis(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> diagnosis(String imagePath) {
		Map<String, Object> data = new HashMap<String, Object>();
		String filepath = "D:/image.bat";
		String newstr = "@echo off"
				+ "\r\n"
				+ "set path=%path%"
				+ "\r\n"
				+ "python D:/tfClassifier-master/tfClassifier-master/image_classification/retrain_model_classifier.py "
				+ " "+imagePath
				+ "\r\n"
				+"exit";
		try {
			FileUtil.writeFileContent(filepath, newstr,false);
			String msg =RunBatUtil.runbat(filepath);
			
			if(StringUtil.isNotBlank(msg)){
				data = JSONObject.parseObject(msg, Map.class);
				System.out.println(data+"-----data-------");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
