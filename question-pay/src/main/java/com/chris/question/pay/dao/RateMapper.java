package com.chris.question.pay.dao;

import com.chris.question.pay.pojo.Rate;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

@Mapper
public interface RateMapper {
    public int insertRate(Rate rate);
    public int deleteRate(Long memberId);
    public int updateRate(Rate rate);
    public Rate getRate(Long memberId);
}
