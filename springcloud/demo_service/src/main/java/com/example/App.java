package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Jack Ji
 * @date 2020/2/11 16:18
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
