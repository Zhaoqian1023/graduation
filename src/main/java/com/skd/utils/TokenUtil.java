/**  
 * @Title: TokenUtil.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月29日
 */
package com.skd.utils;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;


/**
 * ClassName: TokenUtil 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月29日
 */
public class TokenUtil {
	/**
	 * 
	 * @Description: 产生URLtoken
	 * @param @param msg  
	 * @return String  
	 * @author zhaoqian
	 * @date 2018年4月29日
	 */
	public static String getToken(String msg){
		String result = null;
		UUID uiid = UUID.randomUUID();
		String token = uiid.toString();
		byte[] md5=DigestUtils.md5(Constants.SALT+msg+token);
		try {
			result = UrlBase64Coder.encode(md5.toString());
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String uString = UUID.randomUUID().toString();	
		System.out.println(uString);
		System.out.println( uString.replace("-", ""));
		System.out.println( uString.replace("-", ""));
		System.out.println( HashUtil.hashMD5Base64(uString));
		System.out.println( HashUtil.hashSHA1Base64(uString));
		System.out.println( TokenUtil.getToken("371520180416131524456"));
		//4oiCz+9SP8djnqrnS6KJTAZZ
	}

}
