package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Ryan
 * @Date: 2020/6/28 11:42
 * @Version: 1.0
 * @Description:
 */
@Mapper
public interface StorageDao {

    // 扣减库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
