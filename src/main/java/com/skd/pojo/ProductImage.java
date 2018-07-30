package com.skd.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductImage implements Serializable{
    private Integer id;

    private Integer imageId;

    private String pid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }
}