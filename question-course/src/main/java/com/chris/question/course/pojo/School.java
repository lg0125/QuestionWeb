package com.chris.question.course.pojo;



import lombok.Data;

import java.io.Serializable;

import java.sql.Timestamp;
import java.util.List;

@Data
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String content;

    private List<Grade> gradeList;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
