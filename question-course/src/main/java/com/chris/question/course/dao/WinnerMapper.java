package com.chris.question.course.dao;

import com.chris.question.course.pojo.Winner;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

@Mapper
public interface WinnerMapper {
    public int insertWinner(Winner winner);
    public Winner getWinner(Long questionId);
}
