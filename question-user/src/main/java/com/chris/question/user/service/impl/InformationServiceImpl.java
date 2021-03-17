package com.chris.question.user.service.impl;

import com.chris.question.user.dao.InformationMapper;
import com.chris.question.user.pojo.Information;
import com.chris.question.user.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service("InformationService")
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationMapper informationMapper;

    @Override
    public int insertInformation(Information information) {
        return informationMapper.insertInformation(information);
    }

    @Override
    public int deleteInformation(String userId) {
        return informationMapper.deleteInformation(userId);
    }

    @Override
    public int updateInformation(Information information) {
        return informationMapper.updateInformation(information);
    }

    @Override
    public Information getInformation(String userId) {
        return informationMapper.getInformation(userId);
    }


}
