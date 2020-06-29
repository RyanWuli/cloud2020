package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: Ryan
 * @Date: 2020/6/22 16:10
 * @Version: 1.0
 * @Description:
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PaymentService paymentService;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback") // 没有配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")
    @SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "handlerFallback", exceptionsToIgnore = IllegalAccessException.class)
    public CommonResult<Payment> fallBack(@PathVariable("id") Long id) throws IllegalAccessException {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/payment-sql/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalAccessException("IllegalAccessException, 非法参数异常。。。。。");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException, 该 ID 没有对应记录，空指针异常。。。。。");
        }
        return result;
    }

    // 本例是 handlerFallback
    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable throwable) {
        Payment payment = new Payment(id, null);
        return new CommonResult(444,"兜底异常 handlerFallback, exception 内容：" + throwable.getMessage(), payment);
    }

    // 本例是 blockHandler
    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException be) {
        Payment payment = new Payment(id, null);
        return new CommonResult(444,"sentinel 限流 blockHandler,无此流水 BlockException 内容：" + be.getMessage(), payment);
    }

    @GetMapping("/consumer/payment-sql/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    };
}
