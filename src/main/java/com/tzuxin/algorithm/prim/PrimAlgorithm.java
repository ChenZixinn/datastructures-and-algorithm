package com.tzuxin.algorithm.prim;

/**
 * 普里姆算法
 *
 * @author chenzixin
 */
public class PrimAlgorithm {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // 图的节点数量
        int vertexes = 7;
        // 图节点的数据
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // 连接点的权值ß
        int[][] weight = new int[][]{
                    /* A    B   C   D   E   F   G */
                /*A*/ {INF, 5, 7, INF, INF, INF, 2},
                /*B*/ {5, INF, INF, 9, INF, INF, 3},
                /*C*/ {7, INF, INF, INF, 8, INF, INF},
                /*D*/ {INF, 9, INF, INF, INF, 4, INF},
                /*E*/ {INF, INF, 8, INF, INF, 5, 4},
                /*F*/ {INF, INF, INF, 4, 5, INF, 6},
                /*G*/ {2, 3, INF, INF, 4, 6, INF}
        };

        // 创建图对象
        Graph graph = new Graph(vertexes, data, weight);
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
