/**  
 * @Title: PageObject.java
 * @Package com.skd.utils
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd.common;

import java.io.Serializable;

/**
 * ClassName: PageObject
 * 
 * @Description: 分页数据信息对象,需要传的值为当前页和总条数
 * @author zhaoqian
 * @date 2018年4月25日
 */
public class PageObject implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 当前页
	 */
	private int pageCurrent = 1;

	/**
	 * 每页记录数（默认每页10条）
	 */
	private int pageSize = 10;

	/**
	 * 总的记录数
	 */
	private int rowCount;

	/**
	 * 开始显示记录
	 */
	@SuppressWarnings("unused")
	private int startIndex;

	// 总页数
	@SuppressWarnings("unused")
	private int pageCount;

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageCount() {
		int pages = rowCount / pageSize;
		if (0 != rowCount % pageSize) {
			pages += 1;
		}
		return pages;
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getStartIndex() {
		return (this.getPageCurrent() - 1) * pageSize;
	}

}
