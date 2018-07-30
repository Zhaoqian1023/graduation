package com.skd.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Communication implements Serializable{
    private Integer id;

    private Integer spokeA;

    private Integer spokeB;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpokeA() {
        return spokeA;
    }

    public void setSpokeA(Integer spokeA) {
        this.spokeA = spokeA;
    }

    public Integer getSpokeB() {
        return spokeB;
    }

    public void setSpokeB(Integer spokeB) {
        this.spokeB = spokeB;
    }
}