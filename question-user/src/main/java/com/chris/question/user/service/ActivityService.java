package com.chris.question.user.service;

import com.chris.question.common.utils.PageRequest;
import com.chris.question.common.utils.PageResult;
import com.chris.question.user.pojo.Activity;

import java.math.BigInteger;
import java.util.List;

public interface ActivityService {
    public int insertActivity(Activity activity);
    public int deleteActivity(Long activityId);
    public List<Activity> getActivityListByUserId(String userId);

    public PageResult getActivityListPage(String userId, PageRequest pageRequest);
}
