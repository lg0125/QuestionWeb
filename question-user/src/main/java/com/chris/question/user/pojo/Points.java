package com.chris.question.user.pojo;




import lombok.Data;

import java.sql.Timestamp;


@Data
public class Points {
    private Long id;
    private Long points;
    private String userId;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
