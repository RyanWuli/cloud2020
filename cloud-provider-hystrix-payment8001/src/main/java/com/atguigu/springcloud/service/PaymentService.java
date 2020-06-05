package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
//        try {
//            TimeUnit.MILLISECONDS.sleep(13000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        int i = 10 / 0;
        return "线程：" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "~~~~(>_<)~~~~";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程：" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id: " + id + "\t" + "(┬＿┬) 服务器忙或者出错了，请稍后再试。。。";
    }
}
