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
}
