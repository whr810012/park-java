package com.itzeng.springbootstoptool.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ScheduledTaskService {

    private final RestTemplate restTemplate;

    public ScheduledTaskService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // 每20秒调用一次查询全部订单接口
    @Scheduled(fixedRate = 20000)
    public void callExternalApi() {
        String apiUrl = "http://localhost:8080/orderall";  // 假设你要调用本地接口
        String response = restTemplate.getForObject(apiUrl, String.class);
    }
}
