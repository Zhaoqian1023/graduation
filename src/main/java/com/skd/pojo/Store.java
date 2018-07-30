package com.skd.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Store implements Serializable{
    private String sid;

    private String storeName;

    private String hostName;

    private String area;

    private String phone;

    private String location;

    private String identity1Url;

    private String identity2Url;

    private String storePhoto;

    private String license;

    private Integer honor;

    private Date applyTime;

    private Date applyPass;

    private Integer status;

    private String userId;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public String getStorePhoto() {
        return storePhoto;
    }

    public void setStorePhoto(String storePhoto) {
        this.storePhoto = storePhoto == null ? null : storePhoto.trim();
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license == null ? null : license.trim();
    }

    public Integer getHonor() {
        return honor;
    }

    public void setHonor(Integer honor) {
        this.honor = honor;
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