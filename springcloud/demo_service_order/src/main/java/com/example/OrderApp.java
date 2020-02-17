package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jack Ji
 * @date 2020/2/11 17:00
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }

    /**
     * 功能描述:
     * 〈向Spring容器中定义RestTemplate对象〉
     *
     * @param
     * @return org.springframework.web.client.RestTemplate
     * @author Jack Ji
     * @date 2020/2/11 17:02
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
//        return new RestTemplate();
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

}
