package com.skd.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Favorite implements Serializable{
    private Integer id;

    private Integer fType;

    private Date fTime;

    private Integer status;

    private String fKey;

    private String fUid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getfType() {
        return fType;
    }

    public void setfType(Integer fType) {
        this.fType = fType;
    }

    public Date getfTime() {
        return fTime;
    }

    public void setfTime(Date fTime) {
        this.fTime = fTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getfKey() {
        return fKey;
    }

    public void setfKey(String fKey) {
        this.fKey = fKey == null ? null : fKey.trim();
    }

    public String getfUid() {
        return fUid;
    }

    public void setfUid(String fUid) {
        this.fUid = fUid == null ? null : fUid.trim();
    }
}