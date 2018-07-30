package com.skd.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Expert implements Serializable{
    private Integer eid;

    private String expertType;

    private String skillCrop;

    private String company;

    private String location;

    private String identity1Url;

    private String identity2Url;

    private String identityPhoto;

    private String introduce;

    private Date applyTime;

    private Date applyPass;

    private Integer status;

    private String userId;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getExpertType() {
        return expertType;
    }

    public void setExpertType(String expertType) {
        this.expertType = expertType == null ? null : expertType.trim();
    }

    public String getSkillCrop() {
        return skillCrop;
    }

    public void setSkillCrop(String skillCrop) {
        this.skillCrop = skillCrop == null ? null : skillCrop.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
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

    public Date getApplyPass() {
        return applyPass;
    }

    public void setApplyPass(Date applyPass) {
        this.applyPass = applyPass;
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