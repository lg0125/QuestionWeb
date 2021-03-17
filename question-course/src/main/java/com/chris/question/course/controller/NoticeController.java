package com.chris.question.course.controller;

import com.chris.question.course.pojo.Notice;
import com.chris.question.course.service.NoticeService;
import com.chris.question.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@CrossOrigin
@RestController
@RequestMapping("notice/service")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    @PostMapping("/insertion")
    public R insertNotice(@RequestBody Notice notice){
        int result = noticeService.insertNotice(notice);
        return R.ok();
    }

    @DeleteMapping("/deleting/{noticeId}")
    public R deleteNotice(@PathVariable Long noticeId){
        int result = noticeService.deleteNotice(noticeId);
        return R.ok();
    }

    @PutMapping("/updating")
    public R updateNotice(@RequestBody Notice notice){
        int result = noticeService.updateNotice(notice);
        return R.ok();
    }

    @GetMapping("/getting/{noticeId}")
    public R getNotice(@PathVariable Long noticeId){
        return R.ok().put("notice",noticeService.getNotice(noticeId));
    }

}
