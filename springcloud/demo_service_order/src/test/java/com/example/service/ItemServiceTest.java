package com.example.service;

import com.example.OrderApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Jack Ji
 * @date 2020/2/17 10:21
 * @description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ItemServiceTest.class)
@Import(OrderApp.class)
public class ItemServiceTest {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void test() {
        String serviceId = "app-item";
        for (int i = 0; i < 100 ; i++) {
            ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
            System.out.println("item" + (i + 1) + ": " + serviceInstance.getHost() + ": " + serviceInstance.getPort());
        }
    }
}
