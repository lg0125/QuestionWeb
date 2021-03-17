package com.chris.question.course.pojo;


import lombok.Data;

import java.io.Serializable;

import java.sql.Timestamp;

@Data
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String content;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
