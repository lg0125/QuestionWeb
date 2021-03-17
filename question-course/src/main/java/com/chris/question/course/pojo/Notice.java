package com.chris.question.course.pojo;




import lombok.Data;

import java.sql.Timestamp;

@Data
public class Notice {
    private Long id;

    private String content;
    private String photo1;
    private String photo2;
    private String photo3;

    private Course course;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
