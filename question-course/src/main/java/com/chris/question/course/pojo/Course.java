package com.chris.question.course.pojo;



import lombok.Data;

import java.io.Serializable;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String content;
    private String picture;

    private CourseType courseType;
    private Grade grade;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
