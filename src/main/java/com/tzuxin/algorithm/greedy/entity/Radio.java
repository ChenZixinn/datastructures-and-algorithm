package com.tzuxin.algorithm.greedy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 电台类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Radio {
    /**
     * 电台名称
     */
    private String name;
    /**
     * 有多少个匹配的值
     */
    private int mateValue;
    /**
     * 覆盖的城市
     */
    private HashSet<String> cityList;

    public Radio(String name, int mateValue, String[] cityList) {
        this.name = name;
        this.mateValue = mateValue;
        this.cityList = new HashSet<>();
        this.cityList.addAll(Arrays.asList(cityList));
    }
}
