package com.example.feign;

import com.example.entity.Item;
import com.example.fallback.ItemServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 申明这是一个Feign客户端，并且指明服务ID
 * 实际开发中ItemFeignClient一般直接继承(extends)服务提供方的接口以避免代码重复（例如Item工程会以jar包的形式提供ItemService接口）
 * @author Jack Ji
 * @date 2020/2/17 15:18
 * @description
 */
@FeignClient(value="app-item", fallback = ItemServiceFallback.class)
public interface ItemFeignClient {

    /**
     * 功能描述:
     * 〈定义了类似于SpringMVC用法的方法，就可以进行RESTful方式调用了〉
     *
     * @param id
     * @return Item
     * @author Jack Ji
     * @date 2020/2/17 15:21
     */
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    Item queryItemById(@PathVariable("id") Long id);
}
