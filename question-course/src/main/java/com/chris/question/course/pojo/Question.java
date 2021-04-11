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

    public Question(){}
    public Question(Long id,Long points,String title,String content){
        this.id = id;
        this.points = points;
        this.title = title;
        this.content = content;
    }
    public Question(Long id,String photo1,String photo2,String photo3){
        this.id = id;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
    }
}
