/**  
 * @Title: UrlBase64Coder.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月30日
 */
package com.skd.utils;

import org.bouncycastle.util.encoders.UrlBase64;

/**
 * ClassName: UrlBase64Coder 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月30日
 */
public class UrlBase64Coder {
	/*
     * Base64算法最初用于电子邮件系统，后经演变成为显示传递Url参数的一种编码方法
     * 将字符映射表中用作补位的"="换成"."
     * 并用"-"代替"+"
     * 用"_"代替"/"
     * 使得Base64编码符合Url参数规则，可以将二进制数据以Get方式进行传输
     * */
    public final static String ENCODING="UTF-8";
    
    //编码
    public static String encode(String data) throws Exception{
        byte[] b=UrlBase64.encode(data.getBytes(ENCODING));
        return new String(b,ENCODING);
    }
    
    //解码
    public static String decode(String data) throws Exception{
        byte[] b=UrlBase64.decode(data.getBytes(ENCODING));
        return new String(b,ENCODING);
    }
    public static void main(String[] args) {
    	String data="I love the Word 亲爱的世界";        
        System.out.println("编码前->"+data);
        String encipher = "";
		try {
			encipher = UrlBase64Coder.encode(Constants.SALT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("编码后->"+encipher);
        String decipher = "";
		try {
			decipher = UrlBase64Coder.decode(encipher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("解码后->"+decipher);
        System.out.println();
	}

}
