package com.chris.question.user.dao;

import com.chris.question.user.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface ActivityMapper {
    public int insertActivity(Activity activity);
    public int deleteActivity(Long id);
    public List<Activity> getActivityListByUserId(String userId);
}
