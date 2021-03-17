package com.chris.question.pay.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class Rate implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Double rate;
    private Long memberId;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
