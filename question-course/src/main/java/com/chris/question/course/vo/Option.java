package com.chris.question.course.vo;

import lombok.Data;

import java.util.List;

@Data
public class Option {
    private Long value;
    private String label;
    private List<Option> children;
}
