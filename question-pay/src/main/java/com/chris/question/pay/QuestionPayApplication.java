package com.chris.question.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@MapperScan("com.chris.question.pay.dao")
@SpringBootApplication
public class QuestionPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionPayApplication.class, args);
    }

}
