/**  
 * @Title: StringUtil.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


/**
 * ClassName: StringUtil 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
public class StringUtil {
	/**
	 * 替换HTML转义符
	 * @param s
	 * @return
	 */
	public static String replaceHtml(String s) {
		String tmp = s.replaceAll("\\&lt;", "<");
		tmp = tmp.replaceAll("\\&gt;", ">");
		tmp = tmp.replaceAll("\\&amp;", "&");
		tmp = tmp.replaceAll("\\&apos;", "\'");
		tmp = tmp.replaceAll("\\&quot;", "\"");
		tmp = tmp.replaceAll("\\&nbsp;", " ");
		tmp = tmp.replaceAll("<br>", "\n");
		return tmp;
	}
	
	/**
	 * 判断是否非空 null or "" 返回 false 否则返回 true 
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return str != null && str.trim().length() > 0;
	}
	
	/**
	 * 判断是否非空 null or "" 返回 false 否则返回 true 
	 *
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return !isNotBlank(str);
	}
	
	/**
	 * 判断是否非空 null or "" 返回 false 否则返回 true 
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return str != null && str.length() > 0;
	}
	
	/**
	 * 判断是否非空 null or "" 返回 false 否则返回 true 
	 *
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}
	
	/**
	 * 判断某一个字符串数组strList中有没有与字符串aStr相同的
	 *
	 * @param aStr
	 * @param strList
	 * @return
	 */
	public static boolean isIn(String aStr, String[] strList) {
		if (aStr == null || strList == null)
			return false;
		for (int i = 0; i < strList.length; i++) {
			if (strList[i] == null)
				continue;
			else {
				if (strList[i].equals(aStr))
					return true;
			}
		}
		return false;
	}
	/**
	 * 将以厘为单位的金额转换为以元为单位的金额，保留两位小数
	 * @param money 以厘为单位的金额
	 * @return 元为单位的金额
	 */
	public static String moneyFormat(String money){
		float f=Float.parseFloat(money)/1000;
		DecimalFormat decimalFormat=new DecimalFormat(".00");
		return decimalFormat.format(f);
	}
	
	/**
	 * "\\s*|\t|\r|\n"
	 * @param str
	 * @return
	 */
	public static String replaceBlank(String str) {
    	String dest = "";
    	if (str!=null) {
	    	Pattern p = Pattern.compile("\\r");
	    	Matcher m = p.matcher(str);
	    	dest = m.replaceAll("");
    	}
    	return dest;
    }
	
	/**
     * 
     * lpad 方法
     * <p>方法说明:指定一个长度，当指定字符串没有答达长度时，
     * 往字符串左边插入repalce。然后返回一个该长度的字符串</p>  
     * @param s
     * @param n
     * @param repalce
     * @return
     * @author wangsh
     * @since 2013-6-24-下午02:28:07
     */
    public static String lpad(String s,int n,String repalce){
    	StringBuffer sb =new StringBuffer(s);
    	while(sb.length()<n){
    		sb.insert(0, repalce);
    	}
    	return sb.substring(sb.length() -n);
    }
    /**
     * 
     * lpad 方法
     * <p>方法说明:指定一个长度，当指定字符串没有答达长度时，
     * 往字符串右边插入repalce。然后返回一个该长度的字符串</p>  
     * @param s
     * @param n
     * @param repalce
     * @return
     * @author wangsh
     * @since 2013-6-24-下午02:28:07
     */
    public static String rpad(String s,int n,String repalce){
    	StringBuffer sb =new StringBuffer(s);
    	while(sb.length()<n){
    		sb.append(repalce);
    	}
    	return sb.substring(0, n-1);
    }
    
    /**
     * 
     * ifNullGetDefualt 方法
     * <p>方法说明:如果传进来的值为空则返回默认值,如果不为空则返回src.toString()</p>  
     * @param src  
     * @param defualt
     * @return
     * @author wangsh
     * @since 2013-6-24-下午02:28:07
     */
    public static String ifNullGetDefualt(Object src,String defualt) {
    	String value ="";
    	if (defualt ==null) {
    		defualt ="";
    	}
    	if (src ==null||src.equals("")) {
    		value =defualt;
    	} else {
    		value =src.toString();
    	}
    	return value;
    }
    
    public static String converXml(String xml) {
    	String str =xml;
    	if (isNotBlank(xml)){
    		str =xml.replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&").replace("&apos;", "'").replace("&quot;", "");
    	}
    	return str;
    }
    /**
     * 
     * toCamelCase 方法
     * <p>方法说明:单个变更驼峰命名</p>  
     * @param var
     * @return
     * @author wangsh
     * @since 2013-8-3 下午02:28:42
     */
    public static String toCamelCase(String var) {
    	StringBuffer sb =new StringBuffer("");
    	if (var !=null) {
    		String []cc =var.split("_");
    		for (int j = 0; j < cc.length; j++) {
    			if (j==0) {
					sb.append(cc[j]);
				} else {
					if (cc[j].length() ==1) {
						sb.append(cc[j].toUpperCase());
					} else if(cc[j].length() > 1) {
						sb.append(cc[j].substring(0, 1).toUpperCase());
						sb.append(cc[j].substring(1));
					}
				}
    		}
    	}
    	return sb.toString();
    }
    /**
     * 
     * varTOCamelCase 方法
     * <p>方法说明:sql增加驼峰命名别名 输入格式只能是 x.xx,xx,x.xx..... </p>  
     * @param vars
     * @return
     * @author wangsh
     * @since 2013-6-24-下午02:28:07
     */
    public static String varTOCamelCase(String vars){
    	StringBuffer sb =new StringBuffer();
    	if (vars !=null){
    		String var [] =vars.split(",");
    		for (int i = 0; i < var.length; i++) {
    			sb.append(var[i]);
    			sb.append(" \"");
				String []realVars=var[i].split("\\.");
				String realVar =realVars[realVars.length-1];
				String [] cc =realVar.split("_");
				for (int j = 0; j < cc.length; j++) {
					if (j==0) {
						sb.append(cc[j]);
					} else {
						if (cc[j].length() ==1) {
							sb.append(cc[j].toUpperCase());
						} else if(cc[j].length() > 1) {
							sb.append(cc[j].substring(0, 1).toUpperCase());
							sb.append(cc[j].substring(1));
						}
					}
				}
				if (i==var.length-1) {
					sb.append("\" ");
				} else {
					sb.append("\", ");
				}
				
				
			}
    	}
    	return sb.toString();
    }
    /**
	 * 判断订单是否使用了DES加密
	 * @param orderXml
	 * @return
	 */
	public static boolean isDesOrder(String orderXml) {
		if(!StringUtil.isNotBlank(orderXml)){
			return false;
		}
		if(orderXml.contains("<MAPP>")||orderXml.contains("<mapp>")){
			return false;
		}
		return true;
	}

  public static String getOrderWarningMsg(String createDate, int timeOut) throws Exception {
    String warnStr = "";
    if (timeOut > 0) {
      long used = (new Date().getTime() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(
          createDate).getTime())
          / (1000 * 60);
      if (used > timeOut) {
        long day = 0;
        long hour = 0;
        long interval = used - timeOut;
        String usedStr = "";
        if (interval / (60 * 24) >= 1) {
          day = interval / (60 * 24);
          interval = interval - day * 60 * 24;
          warnStr += (day + "天");
        }
        if (interval / 60 >= 1) {
          hour = interval / 60;
          interval = interval - hour * 60;
          warnStr += (hour + "小时");
        }
        if (interval % 60 > 0) {
          warnStr += (interval + "分钟");
        }

        if (used / (60 * 24) >= 1) {
          day = used / (60 * 24);
          used = used - day * 60 * 24;
          usedStr += (day + "天");
        }
        if (used / 60 >= 1) {
          hour = used / 60;
          used = used - hour * 60;
          usedStr += (hour + "小时");
        }
        if (used % 60 > 0) {
          usedStr += (used + "分钟");
        }
        warnStr = "已下单" + usedStr + ",超出预定受理时间" + warnStr + ",请尽快处理!";
      }
    }
    return warnStr;
  }
  
  public static String getPostWarningMsg(String postState,Date postDate){
	  long overTime=2880;
	  long usedTime;
	  String  overTimeStr="";
	  String usedStr="";
	  usedTime = (new Date().getTime()-postDate.getTime())/(1000*60);
	  if(StringUtils.isNotBlank(postState) 
			  || postDate!=null){
		  
		  	if(!"14".equals(postState) && usedTime>overTime){
		  		 StringBuilder  warnStr =  new StringBuilder();
		  		long day = 0;
		        long hour = 0;
		        long interval =usedTime-overTime;
		        
		 
		        if (interval / (60 * 24) >= 1) {
		          day = interval / (60 * 24);
		          interval = interval - day * 60 * 24;
		          overTimeStr += (day + "天");
		        }
		        if (interval / 60 >= 1) {
		          hour = interval / 60;
		          interval = interval - hour * 60;
		          overTimeStr += (hour + "小时");
		        }
		        if (interval % 60 > 0) {
		        	overTimeStr += (interval + "分钟");
		        }

		        if (usedTime / (60 * 24) >= 1) {
		          day = usedTime / (60 * 24);
		          usedTime = usedTime - day * 60 * 24;
		          usedStr += (day + "天");
		        }
		        if (usedTime / 60 >= 1) {
		          hour = usedTime / 60;
		          usedTime = usedTime - hour * 60;
		          usedStr += (hour + "小时");
		        }
		        if (usedTime % 60 > 0) {
		          usedStr += (usedTime + "分钟");
		        }
				 return warnStr.append("已发货").append(usedStr).append(",超出发货时限").append(overTimeStr).append(",请尽快处理！").toString();
		  	}
		     
	  }
	  return ""; 
  }
  //判断包含汉字个数
  public static int containChinese(String str){
	  int count=0;  
	  Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");  
	  char c[] = str.toCharArray();  
	  for(int i=0;i<c.length;i++){
			  Matcher matcher = pattern.matcher(String.valueOf(c[i]));  
			  if(matcher.matches()){  
				  count++;  
			  	} 
		}
		return count;
  	}
  
  public static String yuanToCent(final String o){
      if (o == null)
      {
          return "0";
      }

      String s = o.toString();
      int posIndex = -1;
      String str = "";
      StringBuilder sb = new StringBuilder();
      if (s != null && s.trim().length() > 0 && !s.equalsIgnoreCase("null"))
      {
          posIndex = s.indexOf(".");
          if (posIndex > 0)
          {
              int len = s.length();
              if (len == posIndex + 1)
              {
                  str = s.substring(0, posIndex);
                  if (str == "0")
                  {
                      str = "";
                  }
                  sb.append(str).append("00");
              } else if (len == posIndex + 2)
              {
                  str = s.substring(0, posIndex);
                  if (str == "0")
                  {
                      str = "";
                  }
                  sb.append(str).append(s.substring(posIndex + 1, posIndex + 2)).append("0");
              } else if (len == posIndex + 3)
              {
                  str = s.substring(0, posIndex);
                  if (str == "0")
                  {
                      str = "";
                  }
                  sb.append(str).append(s.substring(posIndex + 1, posIndex + 3));
              } else
              {
                  str = s.substring(0, posIndex);
                  if (str == "0")
                  {
                      str = "";
                  }
                  sb.append(str).append(s.substring(posIndex + 1, posIndex + 3));
              }
          } else
          {
              sb.append(s).append("00");
          }
      } else
      {
          sb.append("0");
      }
      str = removeZero(sb.toString());
      if (str != null && str.trim().length() > 0 && !str.trim().equalsIgnoreCase("null"))
      {
          return str;
      } else
      {
          return "0";
      }
  }
  
  public static String removeZero(String str)
  {
      char ch;
      String result = "";
      if (str != null && str.trim().length() > 0 && !str.trim().equalsIgnoreCase("null"))
      {
          try
          {
              for (int i = 0; i < str.length(); i++)
              {
                  ch = str.charAt(i);
                  if (ch != '0')
                  {
                      result = str.substring(i);
                      break;
                  }
              }
          } catch (Exception e)
          {
              result = "";
          }
      } else
      {
          result = "";
      }
      return result;

  }


}
