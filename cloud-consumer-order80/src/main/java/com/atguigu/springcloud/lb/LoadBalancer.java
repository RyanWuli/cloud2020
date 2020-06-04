package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author: ChaW
 * @date: 2020/6/3
 * @time: 22:45
 * @description: No Description
 * @version: 1.0
 */
public interface LoadBalancer {

    // 获取服务实例
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
