package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.SnowFlakeService;
import com.atguigu.springcloud.util.IdGeneratorSnowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Ryan
 * @Date: 2020/6/29 17:33
 * @Version: 1.0
 * @Description:
 */
@Service
public class SnowFlakeServiceImpl implements SnowFlakeService {

    @Autowired
    private IdGeneratorSnowflake idGeneratorSnowflake;

    @Override
    public String getIDBySnowFlake() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 20; i++) {
            threadPool.submit(() -> {
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }
        threadPool.shutdown();
        return "Hello Snowflake！";
    }
}
