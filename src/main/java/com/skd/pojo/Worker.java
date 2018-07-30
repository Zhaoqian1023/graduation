package com.skd.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Worker implements Serializable{
    private Integer id;

    private String workArea;

    private String workType;

    private String identity1Url;

    private String identity2Url;

    private String identityPhoto;

    private String introduce;

    private Date applyTime;

    private Date paalyPass;

    private Integer status;

    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea == null ? null : workArea.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getIdentity1Url() {
        return identity1Url;
    }

    public void setIdentity1Url(String identity1Url) {
        this.identity1Url = identity1Url == null ? null : identity1Url.trim();
    }

    public String getIdentity2Url() {
        return identity2Url;
    }

    public void setIdentity2Url(String identity2Url) {
        this.identity2Url = identity2Url == null ? null : identity2Url.trim();
    }

    public String getIdentityPhoto() {
        return identityPhoto;
    }

    public void setIdentityPhoto(String identityPhoto) {
        this.identityPhoto = identityPhoto == null ? null : identityPhoto.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getPaalyPass() {
        return paalyPass;
    }

    public void setPaalyPass(Date paalyPass) {
        this.paalyPass = paalyPass;
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