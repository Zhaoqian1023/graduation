package com.skd.pojo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class SpokeEvaluate implements Serializable{
    private Integer id;

    private Integer evluate;

    private Date createTime;

    private String evaluateUser;

    private Integer spokeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvluate() {
        return evluate;
    }

    public void setEvluate(Integer evluate) {
        this.evluate = evluate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEvaluateUser() {
        return evaluateUser;
    }

    public void setEvaluateUser(String evaluateUser) {
        this.evaluateUser = evaluateUser == null ? null : evaluateUser.trim();
    }

    public Integer getSpokeId() {
        return spokeId;
    }

    public void setSpokeId(Integer spokeId) {
        this.spokeId = spokeId;
    }
}