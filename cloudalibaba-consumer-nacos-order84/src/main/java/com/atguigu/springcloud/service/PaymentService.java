package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Ryan
 * @Date: 2020/6/22 17:36
 * @Version: 1.0
 * @Description:
 */
@FeignClient(value = "nacos-payment-service", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping("/payment-sql/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
