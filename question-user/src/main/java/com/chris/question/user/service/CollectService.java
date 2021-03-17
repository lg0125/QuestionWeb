package com.chris.question.user.service;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.user.pojo.Collect;

import java.math.BigInteger;
import java.util.List;

public interface CollectService {
    public int insertCollect(Collect collect);
    public int deleteCollect(Long collectId);
    public Collect getCollect(Long collectId);
    public List<Collect> getCollectListByUserId(String userId);

    public PageResult getCollectListPageByUserId(String userId, PageRequest pageRequest);
}
