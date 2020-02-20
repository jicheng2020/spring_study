package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

/**
 * @author Jack Ji
 * @date 2020/2/17 16:58
 * @description
 */
@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApp.class, args);
    }

    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        ZuulProperties properties = new ZuulProperties();
        System.out.println("properties: " + properties);
        return properties;
    }
}
