package com.example.controller;

import com.example.entity.Item;
import com.example.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jack Ji
 * @date 2020/2/11 15:52
 * @description
 */
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/item/{id}")
    public Item queryItemById(@PathVariable("id") Long id) {
        return itemService.queryItemById(id);
    }
}
