/**  
 * @Title: HashUtil.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月27日
 */
package com.skd.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;


/**
 * ClassName: HashUtil 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月27日
 */
public class HashUtil {
	/**
	 * 使用MD5算法对字符串进行加密
	 * 
	 * @param str
	 *            取得hash值的文字列
	 * @return hash值
	 */
	public static String hashMD5Base64(String str) {
		byte[] md5=DigestUtils.md5(Constants.SALT+str);
		byte[] chs= Base64.encodeBase64(md5);
		return new String(chs);
	}
	
	/**  
     * 解密  
     */    
    @SuppressWarnings("static-access")
	public static String decodeStr(String msg)    
    {    
        Base64 base64 = new Base64();    
        byte[] debytes = base64.decodeBase64(new String(msg).getBytes());    
        return new String(debytes);    
    }    
	public static void main(String[] args) {
		String msg= HashUtil.hashMD5Base64("123456");
		System.out.println(msg);
	}

	/**
	 * 使用SHA1算法对字符串进行加密
	 * 
	 * @param str
	 *            取得hash值的文字列
	 * @return hash值
	 */
	public static String hashSHA1Base64(String str) {
		byte[] sha=DigestUtils.sha1(Constants.SALT+str);
		byte[] chs= Base64.encodeBase64(sha);
		return new String(chs);
	}

}
