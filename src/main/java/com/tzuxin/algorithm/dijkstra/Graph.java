package com.tzuxin.algorithm.dijkstra;

import lombok.Data;
import lombok.ToString;

import java.rmi.MarshalException;

/**
 * 图
 */
@Data
@ToString
public class Graph
{
    /**
     * 存放节点的数据
     */
    private char[] vertexes;
    /**
     * 存放边
     */
    private int[][] matrix;

    /**
     * 构造函数
     * @param vertexes 图的各个顶点的值
     * @param matrix 图的邻接矩阵
     */
    public Graph(char[] vertexes, int[][] matrix) {
        this.vertexes = vertexes;
        this.matrix = matrix;
    }

    public void showMatrix(){
        System.out.printf("%12s", " ");
        for (char vertex : vertexes) {
            System.out.printf("%12c", vertex);
        }
        System.out.println();
        int i = 0;
        for (int[] ints : matrix) {
            System.out.printf("%12c", vertexes[i++]);
            for (int anInt : ints)  {
                System.out.printf("%12d", anInt);
            }
            System.out.println();
        }
    }
}
