/**  
 * @Title: Advise.java
 * @Package com.skd.pojo
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
package com.skd.pojo;

import java.io.Serializable;

/**
 * ClassName: Advise 
 * @Description: TODO
 * @author zhaoqian
 * @date 2018年4月25日
 */
@SuppressWarnings("serial")
public class Advise implements Serializable {
	private Integer id;

    private String title;

    private Integer adviseType;

    private String remark;

    private String userId;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getAdviseType() {
        return adviseType;
    }

    public void setAdviseType(Integer adviseType) {
        this.adviseType = adviseType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

}
