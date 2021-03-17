package com.chris.question.course.service.impl;

import com.chris.question.course.dao.NoticeMapper;
import com.chris.question.course.pojo.Notice;
import com.chris.question.course.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public int insertNotice(Notice notice) {
        return noticeMapper.insertNotice(notice);
    }

    @Override
    public int deleteNotice(Long noticeId) {
        return noticeMapper.deleteNotice(noticeId);
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public Notice getNotice(Long noticeId) {
        return noticeMapper.getNotice(noticeId);
    }
}
