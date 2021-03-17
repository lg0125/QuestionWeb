package com.chris.question.user.pojo;


import lombok.Data;

import java.sql.Timestamp;

/**
 * 问题的转发
 * */

@Data
public class Forward {
    private Long id;
    private Long questionId;
    private String userId;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
