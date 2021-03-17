package com.chris.question.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class WinnerDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String userId;
    private Long questionId;

    private QuestionDto question;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
