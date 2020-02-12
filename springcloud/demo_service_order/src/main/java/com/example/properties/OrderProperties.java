package com.example.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Jack Ji
 * @date 2020/2/12 14:27
 * @description
 */
@Component
@ConfigurationProperties(prefix = "myspcloud")
public class OrderProperties {
    private ItemProperties item = new ItemProperties();

    public ItemProperties getItem() {
        return item;
    }

    public void setItem(ItemProperties item) {
        this.item = item;
    }
}
