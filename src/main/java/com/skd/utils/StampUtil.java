/**  
 * @Title: StampUtil.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月29日
 */
package com.skd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: StampUtil 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月29日
 */
public class StampUtil {
	 /* 
     * 将时间转换为时间戳
     */    
    public static String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    /* 
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    /**
     * 10秒内返回true，否则FALSE
     * @Description: 比较时间戳差值
     * @param @param msg
     * @return boolean  
     * @author zhaoqian
     * @date 2018年4月29日
     */
    public static boolean checkStamp(String msg){
    	Long nowStamp = new Date().getTime();
    	Long msgStamp = Long.valueOf(msg);
    	if((nowStamp - msgStamp) <= (10*1000) && (nowStamp - msgStamp) >= 0){
    		return true;
    	}
    	return true;
    }
    public static void main(String[] args) {
    	try {
    		String dString = StampUtil.dateToStamp("2018-04-29 20:06:23.123");
    		String dString1 = StampUtil.dateToStamp("2018-04-29 20:06:22.123");
    		System.out.println(Long.valueOf(dString)-Long.valueOf(dString1));
    		System.out.println(dString);//1525003583000
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
