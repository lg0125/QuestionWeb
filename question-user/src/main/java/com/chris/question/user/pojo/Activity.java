package com.chris.question.user.pojo;




import lombok.Data;

import java.sql.Timestamp;


/**
 * 对于发起的活动/问题，用户的回答
 * activityId:问题编号
 * commentId:评论编号
 * userId:用户编号
 * */

@Data
public class Activity {
    private Long id;
    private Long questionId;
    private String userId;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
