/**  
 * @Title: Constants.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月27日
 */
package com.skd.utils;



/**
 * ClassName: Constants 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月27日
 */
public class Constants {
	
	/**
	 * 商品ID前缀
	 */
	public final static String PRODUCTID_KEY = "3714";
	/**
	 * 用户ID前缀
	 */
	public final static String USERID_KEY = "3715";
	/**
	 * 店铺ID前缀
	 */
	public final static String STORE_KEY = "3716";
	/**
	 * 订单ID前缀
	 */
	public final static String ORDER_KEY = "3717";
	/**
	 * 支付ID前缀
	 */
	public final static String PAY_KEY = "3718";
	/**
	 * 用户短信注册验证码
	 */
	public final static String REGISTER_REDIS_SMS = "smsMap";
	/**
	 * 用户登录Token
	 */
	public final static String Token_USER = "userToken";
	/**
	 * 用户权限
	 */
	public final static String USER_ROLE = "userRole";
	/**
	 * 默认用户名
	 */
	public final static String USER_NAME = "农友";
	/**
	 * 用户购物车信息
	 */
	public final static String USER_SHOPPING = "userShopping";
	/**
	 * 游客权限
	 */
	public final static String PUBLIC_ROLE = "publicRole";
	/**
	 * 注册方式
	 */
	public final static String REGIS_TYPE_PHONE = "手机号";
	public final static String REGIS_TYPE_WECHAT = "微信号";
	public final static String REGIS_TYPE_QQ = "QQ号";
	/**
	 * 支付方式:本地账户
	 */
	public final static String PAY_TYPE_LOCAL = "0";
	/**
	 * 支付方式:支付宝
	 */
	public final static String PAY_TYPE_ALIPAY = "1";
	/**
	 * 支付方式:微信支付
	 */
	public final static String PAY_TYPE_WECHAT = "2";
	/**
	 * 支付方式:银联
	 */
	public final static String PAY_TYPE_BLANK = "3";
	/**
	 * 支付方式:赠款
	 */
	public final static String PAY_TYPE_DONATE = "4";
	/**
	 * 首页推荐商品类别
	 */
	public final static String INDEX_PRODUCT_TYPE = "特色商品";
	/**
	 * 默认用户角色：农乐（普通购物者）
	 */
	public final static String DEFAULT_USER_ROLE = "6";
	/**
	 * 商品展示条件(综合)
	 */
	public final static String  PRODUCT_SHOW_TYPE_A = "001";
	/**
	 * 商品展示条件(价格)
	 */
	public final static String  PRODUCT_SHOW_TYPE_B = "002";
	/**
	 * 商品展示条件(销量)
	 */
	public final static String  PRODUCT_SHOW_TYPE_C = "003";



	/**
	 * 验证码KEY值
	 */
	public final static String SESSION_KEY_VERIFYCODE = "verifyCode";

	/**
	 * 验证码图片大小
	 */
	public final static int VERIFY_IMAGE_W = 120;
	public final static int VERIFY_IMAGE_H = 50;

	/**
	 * 验证码位数
	 */
	public final static int VERIFY_SIZE = 4;

	/**
	 * MD5加密
	 */
	public final static String KEY_MD5 = "MD5";

	/**
	 * 用户初始密码
	 */
	public final static String INITIAL_PWD = "123456";

	/**
	 * 联系方式类别（1:电话 2:邮箱）
	 */
	public final static String CONTACT_TYPE = "001";
	public final static String CONTACT_TYPE_PHONE = "1"; // 电话
	public final static String CONTACT_TYPE_EMAIL = "2"; // 邮箱

	/**
	 * 性别（f:女 m:男）
	 */
	public final static String SEX_MALE = "m"; // 男

	/**
	 * 操作类型
	 */
	// public final static int OPT_DEFAULT = 0x00;//默认
	public final static int OPT_ADD = 0x01; // 添加
	public final static int OPT_EDIT = 0x02; // 修改
	// public final static int OPT_DELETE = 0x03;//删除
	
	/**
	 * 密码加密的盐
	 */
	public final static String SALT = "Powerd By ZHAO.QIAN";

}
