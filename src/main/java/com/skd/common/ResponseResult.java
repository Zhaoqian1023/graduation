/**  
 * @Title: ResponseResult.java
 * @Package com.skd.vo
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月26日
 */
package com.skd.common;

import java.io.Serializable;

/**
 * ClassName: ResponseResult 
 * @Description: 定义 返回json数据请求的格式
 * @author zhaoqian
 * @date 2018年4月26日
 */
@SuppressWarnings("serial")
public class ResponseResult implements Serializable {
    // 状态码
	private int status = 1;
	// 业务请求是否成功
	private boolean success = true;
	// 存放返回的数据 可以是任何数据
	private Object data;
	// 用于存放返回前台的提示信息 比如：处理成功。或者错误信息
	private String msg = "受理成功";
	/** 总数 */

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String info = "{\"status\":\""+status+"\",\"success\":\""+success+"\",\"data\":\""+data+"\",\"msg\":\""+msg+"\"}";
		return info;
	}

}
