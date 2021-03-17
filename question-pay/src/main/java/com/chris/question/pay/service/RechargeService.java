package com.chris.question.pay.service;

import com.chris.question.pay.pojo.Recharge;

import java.math.BigInteger;

public interface RechargeService {
    public int insertRecharge(Recharge recharge);
    public Recharge getRecharge(Long rechargeId);
}
