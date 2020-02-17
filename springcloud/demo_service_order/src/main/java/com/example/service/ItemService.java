package com.example.service;

import com.example.entity.Item;
import com.example.feign.ItemFeignClient;
import com.example.properties.OrderProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private OrderProperties orderProperties;

    @Autowired
    private ItemFeignClient itemFeignClient;

    public Item queryItemById(Long id) {
//        return restTemplate.getForObject("http://localhost:8081/item/" + id, Item.class);
//        return restTemplate.getForObject(itemUrl + id, Item.class);
//        return restTemplate.getForObject(orderProperties.getItem().getUrl() + id, Item.class);
        // 该方法走eureka注册中心调用(去注册中心根据app-item查找服务，这种方式必须先开启负载均衡@LoadBalanced)
        String itemUrl = "http://app-item/item/{id}";
        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        System.out.println("===========普通 queryItemById-线程池名称：" + Thread.currentThread().getName() + "订单系统调用商品服务,result:" + result);
        return result;
    }

    /**
     * 功能描述:
     * 〈进行容错处理〉
     * fallbackMethod的方法参数保持同原方法一致
     *
     * @param id
     * @return com.example.entity.Item
     * @author Jack Ji
     * @date 2020/2/17 14:31
     */
//    @HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod")
    public Item queryItemById3(Long id) {
//        String itemUrl = "http://app-item/item/{id}";
//        Item result = restTemplate.getForObject(itemUrl, Item.class, id);
        Item result = itemFeignClient.queryItemById(id);
        System.out.println("===========HystrixCommand queryItemById-线程池名称：" + Thread.currentThread().getName() + "订单系统调用商品服务,result:" + result);
        return result;
    }

    /**
     * 功能描述:
     * 〈请求失败的方法，fallbackMethod的方法参数保持同原方法一致〉
     *
     * @param id
     * @return com.example.entity.Item
     * @author Jack Ji
     * @date 2020/2/17 14:37
     */
    public Item queryItemByIdFallbackMethod(Long id) {
        return new Item(id, "query error", null, null, null);
    }

}
