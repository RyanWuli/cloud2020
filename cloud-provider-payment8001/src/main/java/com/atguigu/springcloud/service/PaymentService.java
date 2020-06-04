package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author: ChaW
 * @date: 2020/5/19
 * @time: 21:18
 * @description: No Description
 * @version: 1.0
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
