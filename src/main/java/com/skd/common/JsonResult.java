/**  
 * @Title: JsonResult.java
 * @Package com.skd.vo
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd.common;

/**
 * ClassName: JsonResult 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
public class JsonResult<T> {
	public final static int SUCCESS = 0;
	public final static int ERROR = 1;
	
	
	private int state;
	private String message;
	
	private T data;
	
	public JsonResult() {
		this.state = SUCCESS;
		this.message = "OK";
	}
	
	public JsonResult(Throwable e) {
		this.state = ERROR;
		this.message = e.getMessage();
	}
	
	public JsonResult(T data) {
		this.state = SUCCESS;
		this.data = data;
		this.message = "OK";
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}

}
