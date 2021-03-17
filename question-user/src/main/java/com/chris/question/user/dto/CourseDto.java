package com.chris.question.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class CourseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String content;

    private CourseTypeDto courseType;
    private GradeDto grade;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
