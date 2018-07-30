package com.skd.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Answer implements Serializable{
	
    private Integer id;
    private Integer spokeId;

    private Integer questionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSpokeId() {
        return spokeId;
    }

    public void setSpokeId(Integer spokeId) {
        this.spokeId = spokeId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}