package com.chris.question.user.pojo;



import lombok.Data;

import java.sql.Timestamp;

@Data
public class BlogComment {
    private Long id;
    private Long blogId;
    private String userId;
    private String content;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
