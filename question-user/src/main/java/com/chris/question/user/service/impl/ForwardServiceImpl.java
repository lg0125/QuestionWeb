package com.chris.question.user.service.impl;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.common.utils.PageUtils;
import com.chris.question.user.dao.ForwardMapper;
import com.chris.question.user.pojo.Forward;
import com.chris.question.user.service.ForwardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service("ForwardService")
public class ForwardServiceImpl implements ForwardService {

    @Autowired
    private ForwardMapper forwardMapper;

    @Override
    public int insertForward(Forward forward) {
        return forwardMapper.insertForward(forward);
    }

    @Override
    public int deleteForward(Long forwardId) {
        return forwardMapper.deleteForward(forwardId);
    }

    @Override
    public Forward getForward(Long forwardId) {
        return forwardMapper.getForward(forwardId);
    }

    @Override
    public List<Forward> getForwardListByUserId(String userId) {
        return forwardMapper.getForwardListByUserId(userId);
    }

    @Override
    public PageResult getForwardListPage(String userId, PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfo(userId, pageRequest));
    }

    private PageInfo<Forward> getPageInfo(String userId, PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Forward> list = forwardMapper.getForwardListByUserId(userId);
        return new PageInfo<>(list);
    }
}
