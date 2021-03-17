package com.chris.question.course.pojo;



import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;



@Data
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String userId;
    private Long points;
    private String title;
    private String content;
    private String courseId;

    private String photo1;
    private String photo2;
    private String photo3;


    private Winner winner;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
