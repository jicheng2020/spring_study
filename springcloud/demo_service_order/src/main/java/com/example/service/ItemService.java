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
        return restTemplate.getForObject(orderProperties.getItem().getUrl() + id, Item.class);
    }
}
