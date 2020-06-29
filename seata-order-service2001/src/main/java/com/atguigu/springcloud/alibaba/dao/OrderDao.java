package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Ryan
 * @Date: 2020/6/23 17:58
 * @Version: 1.0
 * @Description:
 */
@Mapper
public interface OrderDao {

    // 1、新建订单
    void create(Order order);

    // 2、修改订单状态，由0到1
    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
