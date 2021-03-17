package com.chris.question.user.dao;

import com.chris.question.user.pojo.Collect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CollectMapper {
    public int insertCollect(Collect collect);
    public int deleteCollect(Long id);
    public Collect getCollect(Long id);
    public List<Collect> getCollectListByUserId(String userId);
}
