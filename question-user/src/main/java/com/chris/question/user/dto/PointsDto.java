package com.chris.question.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PointsDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private Long points;
    private String type;
}
