package com.chris.question.user.service.impl;

import com.chris.question.user.dao.PointsMapper;
import com.chris.question.user.pojo.Points;
import com.chris.question.user.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("PointsService")
public class PointsServiceImpl implements PointsService {

    @Autowired
    private PointsMapper pointsMapper;

    @Override
    public int insertPoints(Points points) {
        return pointsMapper.insertPoints(points);
    }

    @Override
    public int deletePoints(String userId) {
        return pointsMapper.deletePoints(userId);
    }

    @Override
    public int updatePoints(Points points) {
        return pointsMapper.updatePoints(points);
    }

    @Override
    public Points getPoints(String userId) {
        return pointsMapper.getPoints(userId);
    }
}
