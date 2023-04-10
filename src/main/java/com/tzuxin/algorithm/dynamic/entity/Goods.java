package com.tzuxin.algorithm.dynamic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 物品实例
 * @author chenzixin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private String name;
    private int weight;
    private int value;
}
