package com.tzuxin.algorithm.prim;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 图
 */
@Data
public class Graph
{
    /**
     * 图的节点数
     */
    private int vertexes;
    /**
     * 存放节点的数据
     */
    private char[] data;
    /**
     * 存放边
     */
    private int[][] weight;

    /**
     *
//     * @param graph 图对象
     * @param vertexes 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public Graph(int vertexes, char[] data, int[][] weight) {
        this.vertexes = vertexes;
        this.data = data;
        this.weight = weight;
    }
}
