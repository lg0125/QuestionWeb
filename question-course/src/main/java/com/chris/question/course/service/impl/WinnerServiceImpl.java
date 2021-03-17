package com.chris.question.course.service.impl;

import com.chris.question.course.dao.WinnerMapper;
import com.chris.question.course.pojo.Winner;
import com.chris.question.course.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("WinnerService")
public class WinnerServiceImpl implements WinnerService {

    @Autowired
    private WinnerMapper winnerMapper;

    @Override
    public int insertWinner(Winner winner) {
        return winnerMapper.insertWinner(winner);
    }

    @Override
    public Winner getWinner(Long questionId) {
        return winnerMapper.getWinner(questionId);
    }
}
