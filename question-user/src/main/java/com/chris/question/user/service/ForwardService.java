package com.chris.question.user.service;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.user.pojo.Forward;

import java.math.BigInteger;
import java.util.List;

public interface ForwardService {
    public int insertForward(Forward forward);
    public int deleteForward(Long forwardId);
    public Forward getForward(Long forwardId);
    public List<Forward> getForwardListByUserId(String userId);
    public PageResult getForwardListPage(String userId, PageRequest pageRequest);
}
