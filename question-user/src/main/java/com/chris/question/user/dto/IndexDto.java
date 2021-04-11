package com.chris.question.user.dto;

import lombok.Data;

@Data
public class IndexDto {
    private Long questionId;
    private String userId;
    public IndexDto(){}
    public IndexDto(String userId,Long questionId){
        this.userId = userId;
        this.questionId = questionId;
    }
}
