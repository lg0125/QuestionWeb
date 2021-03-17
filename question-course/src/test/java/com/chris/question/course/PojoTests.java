package com.chris.question.course;

import com.chris.question.course.service.CourseService;
import com.chris.question.course.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PojoTests {

    @Autowired
    private CourseService courseService;

    @Autowired
    private NoticeService noticeService;

    @Test
    public void test(){
        System.out.println(courseService.getCourse("30001"));
    }
}
