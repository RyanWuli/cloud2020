package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Ryan
 * @Date: 2020/6/28 14:27
 * @Version: 1.0
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;

    private Long userId;                    // 用户 id

    private BigDecimal total;               // 总额度

    private BigDecimal used;                // 已用额度

    private BigDecimal residue;             // 剩余额度
}
