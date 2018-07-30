/**  
 * @Title: test.java
 * @Package com.skd
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月9日
 */
package com.skd;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.skd.utils.FileUtil;
import com.skd.utils.RunBatUtil;

/**
 * ClassName: test 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月9日
 */
public class test {
	public static void main(String[] args) {
		String filepath = "D:/image.bat";
		String newstr = "@echo off"
				+ "\r\n"
				+ "set path=%path%"
				+ "\r\n"
				+ "python D:/tfClassifier-master/tfClassifier-master/image_classification/retrain_model_classifier.py "
				+ " D:/tfClassifier-master/Picture/0001.jpg"
				+ "\r\n"
				+"exit";
		try {
			FileUtil.writeFileContent(filepath, newstr,false);
			RunBatUtil.runbat(filepath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
