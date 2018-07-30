package com.skd.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Spoke implements Serializable{
    private Integer spokeId;

    private String content;

    private Date spokeTime;

    private Integer flag;

    private Integer status;

    private String userId;

    public Integer getSpokeId() {
        return spokeId;
    }

    public void setSpokeId(Integer spokeId) {
        this.spokeId = spokeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getSpokeTime() {
        return spokeTime;
    }

    public void setSpokeTime(Date spokeTime) {
        this.spokeTime = spokeTime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}