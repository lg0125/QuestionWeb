package com.chris.question.course.dao;

import com.chris.question.course.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface NoticeMapper {
    public int insertNotice(Notice notice);
    public int deleteNotice(Long id);
    public int updateNotice(Notice notice);
    public Notice getNotice(Long id);
    public List<Notice> getNoticeList(String courseId);
}
