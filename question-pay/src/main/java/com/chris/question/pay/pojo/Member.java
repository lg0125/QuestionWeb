package com.chris.question.pay.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String content;

    private Long priority;
    private Long addPoints;
    private Long subPoints;

    //private Rate rate;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
