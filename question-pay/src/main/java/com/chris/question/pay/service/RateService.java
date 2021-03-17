package com.chris.question.pay.service;

import com.chris.question.pay.pojo.Rate;

import java.math.BigInteger;

public interface RateService {
    public int insertRate(Rate rate);
    public int deleteRate(Long memberId);
    public int updateRate(Rate rate);
    public Rate getRate(Long memberId);
}
