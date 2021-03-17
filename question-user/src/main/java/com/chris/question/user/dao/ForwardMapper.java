package com.chris.question.user.dao;

import com.chris.question.user.pojo.Forward;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ForwardMapper {
    public int insertForward(Forward forward);
    public int deleteForward(Long id);
    public Forward getForward(Long id);
    public List<Forward> getForwardListByUserId(String userId);
}
