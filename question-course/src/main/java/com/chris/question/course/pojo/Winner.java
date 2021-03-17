package com.chris.question.course.pojo;



import lombok.Data;

import java.io.Serializable;

import java.sql.Timestamp;


@Data
public class Winner implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String userId;
    private Long questionId;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
