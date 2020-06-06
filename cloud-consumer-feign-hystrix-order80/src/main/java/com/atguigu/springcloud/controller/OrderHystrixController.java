package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Ryan
 * @Date: 2020/6/5 14:30
 * @Version: 1.0
 * @Description:
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    // 指定专属降级方法
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
////    })
    @HystrixCommand // 指标注不指定，则是用全局
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int i = 10 / 0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80，对方支付系统繁忙，请10秒钟后再试；或者自己运行出错，请检查自己，/(ㄒoㄒ)/~~";
    }

    // 全局 fallback 方法
    public String payment_Global_FallbackMethod() {
        return "Global 全局异常处理信息，请稍后再试。。。";
    }
}
