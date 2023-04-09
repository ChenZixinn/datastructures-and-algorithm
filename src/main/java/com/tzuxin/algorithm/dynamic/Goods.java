package com.tzuxin.algorithm.dynamic;

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
    String name;
    int weight;
    int value;

}
