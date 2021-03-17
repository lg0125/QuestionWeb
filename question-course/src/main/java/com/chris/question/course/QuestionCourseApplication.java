package com.chris.question.course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@EnableDiscoveryClient
@MapperScan("com.chris.question.course.dao")
@SpringBootApplication
public class QuestionCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionCourseApplication.class, args);
    }

}
