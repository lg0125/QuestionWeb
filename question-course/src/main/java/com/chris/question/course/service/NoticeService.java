package com.chris.question.course.service;

import com.chris.question.course.pojo.Notice;

import java.math.BigInteger;

public interface NoticeService {
    public int insertNotice(Notice notice);
    public int deleteNotice(Long noticeId);
    public int updateNotice(Notice notice);
    public Notice getNotice(Long noticeId);
}
