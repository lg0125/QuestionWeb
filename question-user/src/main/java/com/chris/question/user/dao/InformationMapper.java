package com.chris.question.user.dao;

import com.chris.question.user.pojo.Information;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface InformationMapper {
    public int insertInformation(Information information);
    public int deleteInformation(String id);
    public int updateInformation(Information information);
    public Information getInformation(String id);
}
