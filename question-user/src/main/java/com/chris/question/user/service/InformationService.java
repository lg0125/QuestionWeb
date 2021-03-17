package com.chris.question.user.service;

import com.chris.question.user.pojo.Information;

import java.math.BigInteger;
import java.util.List;

public interface InformationService {
    public int insertInformation(Information information);
    public int deleteInformation(String userId);
    public int updateInformation(Information information);
    public Information getInformation(String userId);
}
