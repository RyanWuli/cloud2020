package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.SnowFlakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Ryan
 * @Date: 2020/6/29 17:30
 * @Version: 1.0
 * @Description:
 */
@RestController
public class SnowFlakeController {

    @Autowired
    private SnowFlakeService snowFlakeService;

    @GetMapping("/snowflake")
    public String getId() {
        return snowFlakeService.getIDBySnowFlake();
    }
}
