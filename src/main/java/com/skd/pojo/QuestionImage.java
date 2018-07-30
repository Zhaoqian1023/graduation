package com.skd.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class QuestionImage implements Serializable{
    private Integer id;

    private Integer imageId;

    private Integer questionId;

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

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}