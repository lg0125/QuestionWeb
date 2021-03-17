package com.chris.question.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

@Data
public class QuestionDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String userId;
    private Long points;

    private String title;
    private String content;
    private String photo1;
    private String photo2;
    private String photo3;

    //private CourseDto course;
    private WinnerDto winner;
    //private List<CommentDto> commentList;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
