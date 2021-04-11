package com.chris.question.user.pojo;



import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Blog {
    private Long id;
    private String content;
    private String userId;

    private String photo1;
    private String photo2;
    private String photo3;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;

    private List<BlogComment> blogCommentList;

    public Blog(){}
    public Blog(Long id,String content){
        this.id = id;
        this.content = content;
    }
    public Blog(Long id,String photo1,String photo2,String photo3){
        this.id = id;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
    }
}
