package com.chris.question.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class CourseTypeDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
