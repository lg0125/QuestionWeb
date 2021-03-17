package com.chris.question.user.dao;

import com.chris.question.user.pojo.Points;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

@Mapper
public interface PointsMapper {
    public int insertPoints(Points points);
    public int deletePoints(String userId);
    public int updatePoints(Points points);
    public Points getPoints(String userId);
}
