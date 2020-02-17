package com.example.controller;

import com.example.entity.Order;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jack Ji
 * @date 2020/2/11 16:57
 * @description
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{orderId}")
    public Order queryOrderById(@PathVariable("orderId") String orderId) {
        return orderService.queryOrderById(orderId);
    }

    @GetMapping("/order2/{orderId}")
    public Order queryOrderById2(@PathVariable("orderId") String orderId) {
        return orderService.queryOrderByIdx(orderId);
    }

}
