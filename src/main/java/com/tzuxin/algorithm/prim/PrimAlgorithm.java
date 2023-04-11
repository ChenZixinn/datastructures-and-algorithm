package com.tzuxin.algorithm.prim;

/**
 * 普里姆算法
 *
 * @author chenzixin
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        // 图的节点数量
        int verxs = 7;
        // 图节点的数据
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // 连接点的权值
        int[][] weight = new int[][]{
                {Integer.MAX_VALUE, 5, 7, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2},
                {5, Integer.MAX_VALUE, Integer.MAX_VALUE, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, 3},
                {7, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 9, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 8, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 4},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 5, Integer.MAX_VALUE, 6},
                {2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 6, Integer.MAX_VALUE}
        };
        // 创建图对象
        Graph graph = new Graph(verxs, data, weight);
        // 创建最小生成树
        MinTree minTree = new MinTree(graph);
//        minTree.showGraph(graph);

        // prim算法生成最小生成树
        minTree.prim(graph, 0);
        /*
         * 输出：
         * 边->A---G，权值为2
         * 边->G---B，权值为3
         * 边->G---E，权值为4
         * 边->E---F，权值为5
         * 边->F---D，权值为4
         * 边->A---C，权值为7
         */
    }
}
