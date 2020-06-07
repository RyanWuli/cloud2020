package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Ryan
 * @Date: 2020/6/5 11:19
 * @Version: 1.0
 * @Description:
 */
@Service
public class PaymentService {

    /**
     * 模拟 ok 状态
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程：" + Thread.currentThread().getName() + " paymentInfo_OK,id: " + id + "\t" + "o(∩_∩)o 哈哈";
    }

    /**
     * 模拟超时
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
//        int timeNumber = 5;
//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        int i = 10 / 0;
        return "线程：" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "~~~~(>_<)~~~~";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程：" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "(┬＿┬) 8001服务器忙或者出错了，请稍后再试。。。";
    }


    // =====服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("***********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t 调用成功，流水号：" + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数，请稍后再试/(ㄒoㄒ)/~~";
    }
}
