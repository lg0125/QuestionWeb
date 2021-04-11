package com.chris.question.user.pojo;



import lombok.Data;

import java.sql.Timestamp;

@Data
public class Information {
    private Long id;

    private String name;
    private String sex;
    private String city;
    private String province;
    private String work;
    private String avatar;

    private String userId;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
