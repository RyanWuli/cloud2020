package com.atguigu.springcloud;

import cn.hutool.db.sql.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: ChaW
 * @date: 2020/5/27
 * @time: 21:35
 * @description: No Description
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class, args);
    }
}
