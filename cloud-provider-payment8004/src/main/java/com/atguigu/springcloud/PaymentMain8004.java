package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: ChaW
 * @date: 2020/5/27
 * @time: 20:33
 * @description: No Description
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient // consul 或者 zookeeper 作为注册中心的时候标注服务
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
