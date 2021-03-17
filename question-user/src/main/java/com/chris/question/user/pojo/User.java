package com.chris.question.user.pojo;



import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class User {
    private String id;
    private String password;

    private String cardId;
    private Long memberId;

    private Information information;
    private Points points;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;

    /*
     * 对Question的操作
     * */
    private List<Activity> activityIndexList;
    private List<Collect> collectIndexList;
    private List<Forward> forwardIndexList;

    private List<Blog> blogList;
}
