package com.atguigu.springcloud.alibaba.service;

/**
 * @Author: Ryan
 * @Date: 2020/6/28 11:53
 * @Version: 1.0
 * @Description:
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
