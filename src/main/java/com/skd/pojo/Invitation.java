package com.skd.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Invitation implements Serializable{
    private Integer id;

    private String invitationCode;

    private Date bindTime;

    private String remark;

    private String newUser;

    private String oldUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getNewUser() {
        return newUser;
    }

    public void setNewUser(String newUser) {
        this.newUser = newUser == null ? null : newUser.trim();
    }

    public String getOldUser() {
        return oldUser;
    }

    public void setOldUser(String oldUser) {
        this.oldUser = oldUser == null ? null : oldUser.trim();
    }
}