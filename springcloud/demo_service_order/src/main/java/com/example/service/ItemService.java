package com.example.service;

import com.example.entity.Item;
import com.example.properties.OrderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Jack Ji
 * @date 2020/2/11 16:49
 * @description
 */
@Service
public class ItemService {
    // Spring对RESTful方式的http请求做了封装，简化操作
    @Autowired
    private RestTemplate restTemplate;

//    @Value("${myspcloud.item.url}")
//    private String itemUrl;

    @Autowired
    OrderProperties orderProperties;
    public Item queryItemById(Long id) {
//        return restTemplate.getForObject("http://localhost:8081/item/" + id, Item.class);
//        return restTemplate.getForObject(itemUrl + id, Item.class);
//        return restTemplate.getForObject(orderProperties.getItem().getUrl() + id, Item.class);
        // 该方法走eureka注册中心调用(去注册中心根据app-item查找服务，这种方式必须先开启负载均衡@LoadBalanced)
        String itemUrl = "http://app-item/item/{id}";
        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        System.out.println("order result: " + result);
        return result;
    }
}
