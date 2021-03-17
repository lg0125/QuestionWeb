package com.chris.question.user.service.impl;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.common.utils.PageUtils;
import com.chris.question.user.dao.ActivityMapper;
import com.chris.question.user.pojo.Activity;
import com.chris.question.user.service.ActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service("ActivityService")
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int insertActivity(Activity activity) {
        return activityMapper.insertActivity(activity);
    }

    @Override
    public int deleteActivity(Long activityId) {
        return activityMapper.deleteActivity(activityId);
    }

    @Override
    public List<Activity> getActivityListByUserId(String userId) {
        return activityMapper.getActivityListByUserId(userId);
    }

    @Override
    public PageResult getActivityListPage(String userId, PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest,getPageInfo(userId,pageRequest));
    }

    private PageInfo<Activity> getPageInfo(String userId, PageRequest pageRequest){
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        List<Activity> list = activityMapper.getActivityListByUserId(userId);
        return new PageInfo<>(list);
    }
}
