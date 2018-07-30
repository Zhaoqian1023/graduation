/**  
 * @Title: PasswordUtil.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
package com.skd.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * ClassName: PasswordUtil 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年5月1日
 */
public class PrimaryKeyUtil {
	
	/**
	 *用户ID生成规则
	 * @Description: TODO
	 * @param @return   
	 * @return String  
	 * @author zhaoqian
	 * @date 2018年5月1日
	 */
	public static String createUserId(){
		String msg = null;
		Long nowStamp = new Date().getTime();
		msg = Constants.USERID_KEY + String.valueOf(nowStamp);
		return msg;
	}
	/**
	 * 订单ID生成规则
	 * @Description: TODO
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年5月1日
	 */
	public static String createOrderId(){
		String msg = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		msg = Constants.ORDER_KEY+sdf.format(new Date())+RandomUtil.getRandom(6);
		return msg;
	}
	/**
	 * 商品ID生成规则
	 * @Description: TODO
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年5月1日
	 */
	public static String createProductId(){
		String msg = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		msg = Constants.PRODUCTID_KEY+sdf.format(new Date())+RandomUtil.getRandom(3);
		return msg;
	}
	/**
	 * 付款ID生成规则
	 * @Description: TODO
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author zhaoqian
	 * @date 2018年5月1日
	 */
	public static String createPayId(){
		String msg = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		msg = Constants.PAY_KEY+sdf.format(new Date())+RandomUtil.getRandom(6);
		return msg;
	}
	
	
	public static void main(String[] args) {
		System.out.println(PrimaryKeyUtil.createOrderId());
	}

}
