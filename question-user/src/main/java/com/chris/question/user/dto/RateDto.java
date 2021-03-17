package com.chris.question.user.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class RateDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Double rate;
    private Long memberId;

    private Integer del;
    private Integer version;
    private Timestamp createDate;
    private Timestamp modifyDate;
}
