package com.chris.question.pay.service.impl;

import com.chris.question.pay.dao.RateMapper;
import com.chris.question.pay.pojo.Rate;
import com.chris.question.pay.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("RateService")
public class RateServiceImpl implements RateService {

    @Autowired
    private RateMapper rateMapper;

    @Override
    public int insertRate(Rate rate) {
        return rateMapper.insertRate(rate);
    }

    @Override
    public int deleteRate(Long memberId) {
        return rateMapper.deleteRate(memberId);
    }

    @Override
    public int updateRate(Rate rate) {
        return rateMapper.updateRate(rate);
    }

    @Override
    public Rate getRate(Long memberId) {
        return rateMapper.getRate(memberId);
    }
}
