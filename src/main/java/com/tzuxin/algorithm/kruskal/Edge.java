package com.tzuxin.algorithm.kruskal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 边
 */
@Data
@AllArgsConstructor
@ToString
public class Edge {
    /**
     * 起点
     */
    char start;
    /**
     * 终点
     */
    char end;
    /**
     * 边的权值
     */
    int weight;
}
