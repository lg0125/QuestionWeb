package com.chris.question.user.dto;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String password;

    private Long cardId;
    private Long memberId;
}
