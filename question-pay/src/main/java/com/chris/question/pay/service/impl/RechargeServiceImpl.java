package com.chris.question.pay.service.impl;

import com.chris.question.pay.dao.RechargeMapper;
import com.chris.question.pay.pojo.Recharge;
import com.chris.question.pay.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("RechargeService")
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private RechargeMapper rechargeMapper;

    @Override
    public int insertRecharge(Recharge recharge) {
        return rechargeMapper.insertRecharge(recharge);
    }

    @Override
    public Recharge getRecharge(Long rechargeId) {
        return rechargeMapper.getRecharge(rechargeId);
    }
}
