package com.chris.question.user.service.impl;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.common.utils.PageUtils;
import com.chris.question.user.dao.CollectMapper;
import com.chris.question.user.pojo.Collect;
import com.chris.question.user.service.CollectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service("CollectService")
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public int insertCollect(Collect collect) {
        return collectMapper.insertCollect(collect);
    }

    @Override
    public int deleteCollect(Long collectId) {
        return collectMapper.deleteCollect(collectId);
    }

    @Override
    public Collect getCollect(Long collectId) {
        return collectMapper.getCollect(collectId);
    }

    @Override
    public List<Collect> getCollectListByUserId(String userId) {
        return collectMapper.getCollectListByUserId(userId);
    }

    @Override
    public PageResult getCollectListPageByUserId(String userId, PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfo(userId,pageRequest));
    }

    private PageInfo<Collect> getPageInfo(String userId, PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Collect> list = collectMapper.getCollectListByUserId(userId);
        return new PageInfo<>(list);
    }
}
