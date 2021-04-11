package com.chris.question.user.pojo;



import lombok.Data;

import java.sql.Timestamp;

@Data
public class BlogComment {
    private Long id;
    private Long blogId;
    private String userId;
    private String content;
    private String photo1;
    private String photo2;
    private String photo3;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;

    public BlogComment(){}
    public BlogComment(Long id,String content){
        this.id = id;
        this.content = content;
    }
    public BlogComment(Long id,String photo1,String photo2,String photo3){
        this.id = id;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
    }
}
