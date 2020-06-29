package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.AccessControlContext;

/**
 * @Author: Ryan
 * @Date: 2020/6/24 15:00
 * @Version: 1.0
 * @Description:
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("----->开始创建订单");
        // 新建订单
        orderDao.create(order);

        log.info("----->订单微服务开始调用库存，做扣减 Count...");
        // 扣减库存
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减 end");

        log.info("----->订单微服务开始调用账户，扣钱 Money...");
        // 扣减 money
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->订单微服务开始调用账户，扣钱 end");

        // 修改订单状态，从0-1，1代表订单完成
        log.info("----->修改订单状态开始");
        // 修改订单
        orderDao.update(order.getUserId(), 0);
        log.info("----->修改订单状态结束");
        log.info("----->下订单结束，o(∩_∩)o 哈哈");
    }
}
