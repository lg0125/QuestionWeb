package com.chris.question.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@EnableFeignClients(basePackages = "com.chris.question.user.feign")
@EnableDiscoveryClient
@MapperScan("com.chris.question.user.dao")
@SpringBootApplication
public class QuestionUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionUserApplication.class, args);
    }

}
