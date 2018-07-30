package com.skd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * 对一些常用数据进行操作的工具类
 * 
 * @author Admin
 *
 */
public class DataOptUtil {
	/** 日期长格式 */
	public static final String DATE_PATTERN_LONG = "yyyy-MM-dd HH:mm:ss";
	/** 日期格式 */
	public static final String DATE_PATTERN = "yyyy-MM-dd";

	public static boolean isNotNull(String str) {
		if (null != str && !"".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNull(String str) {
		if (null == str || "".equals(str)) {
			return true;
		} else {
			return false;
		}
	}

	public static int parseInt(String str) {
		if (isNotNull(str)) {
			return Integer.parseInt(str);
		} else {
			throw new RuntimeException("字符串为空，不能转换成数字");
		}
	}

	public static Date parseDate(String str, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		if (isNotNull(str)) {
			try {
				date = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			throw new RuntimeException("字符串为空，不能转换成日期");
		}
		return date;
	}

	public static Date parseDate(String str) {
		return parseDate(str, DataOptUtil.DATE_PATTERN);
	}

	public static Date parseLongDate(String str) {
		return parseDate(str, DataOptUtil.DATE_PATTERN_LONG);
	}

	public static String date2String(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static String Date2String(Date date) {
		return date2String(date, DataOptUtil.DATE_PATTERN);
	}

	public static String Date2LongString(Date date) {
		return date2String(date, DataOptUtil.DATE_PATTERN_LONG);
	}

	public static int getSize(Collection<?> coll) {
		int size = coll == null ? 0 : coll.size();
		return size;
	}

	public static int getSize(Map<?, ?> map) {
		int size = map == null ? 0 : map.size();
		return size;
	}

	public static int getLength(Object[] obj) {
		int length = 0;
		length = obj == null ? 0 : obj.length;
		return length;
	}

	/**
	 * 计算两个时间相差的秒数
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static long calcSeconds(String time1, String time2, String patern) {
		if (DataOptUtil.isNull(patern)) {
			patern = DATE_PATTERN_LONG;
		}
		Date date1 = parseDate(time1, patern);
		Date date2 = parseDate(time2, patern);
		return Math.abs((date1.getTime() - date2.getTime())) / 1000;
	}

	/**
	 * 根据日期获取是星期几
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		String week = sdf.format(date);
		return week;
	}

	/**
	 * 计算2个日期相差的时分秒
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 */
	public static String dateDiff(String time1, String time2) {
		long diff = calcSeconds(time1, time2, DATE_PATTERN_LONG);
		int hour = (int) ((diff % 86400) / 3600);
		int min = (int) ((diff % 3600) / 60);
		int sec = (int) (diff % 60);
		StringBuilder sb = new StringBuilder(100);
		if (hour > 0) {
			sb.append(hour);
			sb.append("时");
		}
		if (min > 0) {
			sb.append(min);
			sb.append("分");
		}
		if (sec > 0) {
			sb.append(sec);
			sb.append("秒");
		}
		return sb.toString();
	}
}