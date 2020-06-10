package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Ryan
 * @Date: 2020/6/10 15:16
 * @Version: 1.0
 * @Description:
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageService iMessageService;

    @GetMapping("/message/send")
    public String sendMessage() {
        String send = iMessageService.send();
        return send;
    }
}
