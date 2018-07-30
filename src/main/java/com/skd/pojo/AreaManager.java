package com.skd.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class AreaManager implements Serializable{
    private Integer id;

    private String company;

    private String companyAddr;

    private String managerArea;

    private String title;

    private String managerType;

    private String identity1Url;

    private String identity2Url;

    private String identityPhoto;

    private String introduce;

    private Date applyTime;

    private Date applyPass;

    private Integer status;

    private String userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    public String getManagerArea() {
        return managerArea;
    }

    public void setManagerArea(String managerArea) {
        this.managerArea = managerArea == null ? null : managerArea.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType == null ? null : managerType.trim();
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