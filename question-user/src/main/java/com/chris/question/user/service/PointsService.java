package com.chris.question.user.service;

import com.chris.question.user.pojo.Points;

import java.math.BigInteger;

public interface PointsService {
    public int insertPoints(Points points);
    public int deletePoints(String userId);
    public int updatePoints(Points points);
    public Points getPoints(String userId);
}
