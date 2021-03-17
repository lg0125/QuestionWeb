package com.chris.question.pay.dao;

import com.chris.question.pay.pojo.Recharge;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

@Mapper
public interface RechargeMapper {
    public int insertRecharge(Recharge recharge);
    public Recharge getRecharge(Long id);
}
