package com.tzuxin.algorithm.prim;

import java.util.Arrays;

/**
 * 最小生成树类
 */
public class MinTree {
    Graph graph;

    public MinTree(Graph graph) {
        this.graph = graph;
    }

    /**
     * Prim算法，得到最小生成树
     * @param graph 图
     * @param v     从那个顶点开始生成
     */
    public void prim(Graph graph, int v) {
        // 标记节点是否访问过 0是没访问过 1是访问过
        int[] isVisited = new int[graph.getVertexes()];

        // 标记为已访问
        isVisited[v] = 1;
        // 用来标记顶点下标
        int h1 = -1;
        int h2 = -1;
        // 用来对比权值的值
        int minWeight = Integer.MAX_VALUE;

        // 需要n-1条边
        for (int k = 1; k < graph.getVertexes(); k++) {

            // 确定每一次生成的子图(i节点)能到达的权值最小的没访问过的点(j)
            // i表示已经访问的节点，j表示没被访问过的节点
            for (int i = 0; i < graph.getVertexes(); i++) {
                for (int j = 0; j < graph.getVertexes(); j++) {
                    if (isVisited[i] == 1 && isVisited[j] == 0 && graph.getWeight()[i][j] < minWeight) {
                        h1 = i;
                        h2 = j;
                        minWeight = graph.getWeight()[i][j];
                    }
                }
            }
            // 输出此次找到的节点
            System.out.println("边->" + graph.getData()[h1] + "---" + graph.getData()[h2] + "，权值为" + graph.getWeight()[h1][h2]);
            // 重置参数
            isVisited[h2] = 1;
            minWeight = Integer.MAX_VALUE;
        }
    }

    /**
     * 展示图的weight属性
     *
     * @param graph 图
     */
    public void showGraph(Graph graph) {
        for (int[] link : graph.getWeight()) {
            System.out.println(Arrays.toString(link));
        }
    }
}
