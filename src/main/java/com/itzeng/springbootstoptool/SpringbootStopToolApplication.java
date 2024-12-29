package com.itzeng.springbootstoptool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling  // 启用定时任务功能
public class SpringbootStopToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStopToolApplication.class, args);
    }
}
