package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Ryan
 * @Date: 2020/6/28 11:35
 * @Version: 1.0
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

    private Long id;

    private Long productId;                 // 产品 id

    private Integer total;                  // 总库存

    private Integer used;                   // 已用库存

    private Integer residue;                // 剩余库存
}
