/**  
 * @Title: RunBatUtil.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月6日
 */
package com.skd.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**执行bat文件
 * ClassName: RunBatUtil
 * 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年6月6日
 */
public class RunBatUtil {
	private static Logger logger = LoggerFactory.getLogger(RunBatUtil.class);
	public static String runbat(String batName) {
		String msg="";
		try {
			Process ps = Runtime.getRuntime().exec(batName);
			InputStream in = ps.getInputStream();
			InputStreamReader isr=new InputStreamReader(in);
			BufferedReader bufferedReader = new BufferedReader(isr);  
			String c;
			while ((c=bufferedReader.readLine()) != null) {
				System.out.print(c);
				msg += c;
			}
			in.close();
			isr.close();
			bufferedReader.close();
			ps.waitFor();

		} catch (IOException ioe) {
			logger.error("执行bat文件错误："+ioe.getMessage());
		} catch (InterruptedException e) {
			logger.error("执行bat文件错误："+e.getMessage());
		}
		return msg;
	}

	public static void main(String[] args) {
		String batName = "F:\\database_backup\\ngx_backup\\backup_ngx.bat";
		RunBatUtil.runbat(batName);
		System.out.println("main thread");
	}

}
