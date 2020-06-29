package com.atguigu.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @Author: Ryan
 * @Date: 2020/6/28 14:38
 * @Version: 1.0
 * @Description:
 */
public interface AccountService {

    /**
     * 扣减用户余额
     * @param userId
     * @param money
     */
    void decrease(Long userId, BigDecimal money);
}
