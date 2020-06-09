package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ChaW
 * @date: 2020/6/9
 * @time: 20:07
 * @description: No Description
 * @version: 1.0
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${info.age}")
    private String infoAge;

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/get/port")
    public String getInfoAge() {
        return infoAge;
    }

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return serverPort + configInfo;
    }
}
