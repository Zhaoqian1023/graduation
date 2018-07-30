package com.skd.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SpokeImage implements Serializable{
    private Integer id;

    private Integer imageId;

    private Integer spokeId;

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

    public Integer getSpokeId() {
        return spokeId;
    }

    public void setSpokeId(Integer spokeId) {
        this.spokeId = spokeId;
    }
}