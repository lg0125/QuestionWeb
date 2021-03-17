package com.chris.question.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class GradeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String content;

    private SchoolDto school;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;

}
