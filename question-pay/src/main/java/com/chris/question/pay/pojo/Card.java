package com.chris.question.pay.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Double money;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
