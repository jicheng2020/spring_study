package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jack Ji
 * @date 2020/2/12 15:29
 * @description
 */
@SpringBootApplication
@EnableEurekaServer
@RestController
public class AppEurekaServerFirst {
    public static void main(String[] args) {
        SpringApplication.run(AppEurekaServerFirst.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

}
