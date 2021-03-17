package com.chris.question.pay.pojo;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;


@Data
public class Recharge {
    private Long id;
    private Double money;
    private String cardId;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
