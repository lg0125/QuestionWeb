package com.chris.question.user.dto;

import lombok.Data;

@Data
public class Index {
    private Long id;
    private String userId;
    public Index(){}
    public Index(String userId,Long id){
        this.userId = userId;
        this.id = id;
    }
}
