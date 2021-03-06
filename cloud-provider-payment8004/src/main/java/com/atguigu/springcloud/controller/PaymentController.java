package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author: ChaW
 * @date: 2020/5/27
 * @time: 20:39
 * @description: No Description
 * @version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentZK() {
        return "springcloud with zookeeper:" + serverPort + UUID.randomUUID().toString();
    }
}
