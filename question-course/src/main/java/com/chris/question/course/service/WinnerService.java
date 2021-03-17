package com.chris.question.course.service;

import com.chris.question.course.pojo.Winner;

import java.math.BigInteger;

public interface WinnerService {
    public int insertWinner(Winner winner);
    public Winner getWinner(Long questionId);
}
