package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Ryan
 * @Date: 2020/6/18 15:32
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class FlowLimitController {

    @GetMapping("/a")
    public String testA() {
//        try {
//            TimeUnit.MILLISECONDS.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "------testA";
    }

    @GetMapping("/b")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t -----testB");
        return "------testB";
    }

    @GetMapping("/d")
    public String testD() {
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("异常比例-----testD");
        int age = 10/0;
//        log.info("-----testD 测试 RT");
        return "------testD";
    }


    @GetMapping("/e")
    public String testE() {
        log.info("测试异常数-----testE");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey", blockHandler = "deal_testTotKey")
    public String testTotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "-----testTotKey";
    }
    public String deal_testTotKey(String p1, String p2, BlockException e) {
        return "-----deal_testTotKey, (づ╥﹏╥)づ"; // 默认的是 Blocked by Sentinel (flow limiting)
    }
}
