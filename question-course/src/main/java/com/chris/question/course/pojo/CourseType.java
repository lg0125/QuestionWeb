package com.chris.question.course.pojo;



import lombok.Data;

import java.io.Serializable;

import java.sql.Timestamp;


@Data
public class CourseType implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
