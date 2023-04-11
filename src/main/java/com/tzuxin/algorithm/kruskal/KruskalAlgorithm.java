package com.tzuxin.algorithm.kruskal;

import lombok.Data;

import java.util.Arrays;

/**
 * 克鲁思卡尔(Kruskal)算法
 */
@Data
public class KruskalAlgorithm {

    public static void main(String[] args) {
        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // 邻接矩阵
        int[][] matrix = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0},};

        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(vertexes, matrix);
//        kruskalAlgorithm.print();
        kruskalAlgorithm.kruskal();
    }

    private static final int INF = Integer.MAX_VALUE;
    /**
     * 顶点数组
     */
    private char[] vertexes;
    /**
     * 邻接矩阵
     */
    private int[][] matrix;
    /**
     * 边的数量
     */
    private int edgeNum;
    /**
     * 边的数组
     */
//    Edge[] edges;

    /**
     * 构造器
     *
     * @param vertexes 顶点的数组
     * @param matrix   邻接矩阵
     */
    public KruskalAlgorithm(char[] vertexes, int[][] matrix) {
        this.vertexes = vertexes.clone();
        this.matrix = matrix.clone();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    /**
     * 克鲁斯卡尔算法
     */
    public void kruskal() {
        // 表示最后数组结果的索引
        int index = 0;
        // 存放最小生成树中节点的终点
        int[] ends = new int[edgeNum];
        // 记录最后的结果,边的数量=节点-1
        Edge[] rest = new Edge[vertexes.length-1];

        // 获取所有边的集合
        Edge[] edges = getEdgesList();

        // 遍历所有的边，判断是否会形成回路，不会的就加入到rest数组中
        for (Edge edge : edges) {
            // 查询这条边两个顶点的下标
            int p1 = getPosition(edge.getStart());
            int p2 = getPosition(edge.getEnd());
            // 找到这两个点的终点
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            // 如果没有形成回路
            if (m != n) {
                // 记录m的终点为n
                ends[m] = n;
                // 把这条线加入结果数组中
                rest[index++] = edge;
            }
        }
        System.out.println("result: " + Arrays.toString(rest));
    }

    /**
     * 对边进行冒泡排序
     *
     * @param edges 边的数组
     */
    private void sortEdges(Edge[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edge tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 输入顶点的值，返回顶点的下标
     *
     * @param ch 顶点的值
     * @return 顶点的下标
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 得到包含所有边的数组
     */
    public Edge[] getEdgesList() {
        int index = 0;
        Edge[] edges = new Edge[edgeNum];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new Edge(vertexes[i], vertexes[j], matrix[i][j]);
                }
            }
        }
        this.sortEdges(edges);
        return edges;
    }

    /**
     * 获取下标为i的顶点的重点，用于判断两个顶点的终点是否一直
     *
     * @param ends 各个顶点对应的终点
     * @param i    顶点的下标
     * @return 终点的下标
     */
    public int getEnd(int[] ends, int i) {
        // 如果终点不是0，则一直寻找
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    /**
     * 打印邻接矩阵
     */
    public void print() {
        System.out.println("邻接矩阵如下：");
        System.out.printf("%1c", ' ');
        for (char vertex : vertexes) {
            System.out.printf("%12c", vertex);
        }
        System.out.println();
        for (int i = 0; i < vertexes.length; i++) {
            System.out.printf("%1c", vertexes[i]);
            for (int j = 0; j < vertexes.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
