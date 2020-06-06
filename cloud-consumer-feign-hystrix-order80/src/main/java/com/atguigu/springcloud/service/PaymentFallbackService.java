package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: Ryan
 * @Date: 2020/6/6 9:29
 * @Version: 1.0
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----- PaymentFallbackService fall back - paymentInfo_OK, ♪(＾∀＾●)ﾉ";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----- PaymentFallbackService fall back - paymentInfo_TimeOut, ♪(＾∀＾●)ﾉ";
    }
}
