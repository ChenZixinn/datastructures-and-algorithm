package com.tzuxin.algorithm.floyd;

/**
 * Floyd算法解决最小生成树问题
 */
public class  FloydAlgorithm {

    public static void main(String[] args) {
        // 测试看看图是否创建成功
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };

        //创建 Graph 对象
        Graph graph = new Graph(vertex.length, matrix, vertex);
        //调用弗洛伊德算法
        floyd(graph);
        graph.show();
    }

    /**
     * 弗洛伊德算法
     * @param graph 图
     */
    public static void floyd(Graph graph) {
        //变量保存距离
        int len = 0;
        //对中间顶点遍历， k 就是中间顶点的下标 [A, B, C, D, E, F, G]
        for(int k = 0; k < graph.getDis().length; k++) {
            //从i顶点开始出发 [A, B, C, D, E, F, G]
            for(int i = 0; i < graph.getDis().length; i++) {
                //到达j顶点 // [A, B, C, D, E, F, G]
                for(int j = 0; j < graph.getDis().length; j++) {
                    // => 求出从i 顶点出发，经过 k中间顶点，到达 j 顶点距离
                    len = graph.getDis()[i][k] + graph.getDis()[k][j];
                    //如果len小于 dis[i][j]
                    if(len < graph.getDis()[i][j]) {
                        //更新距离
                        graph.getDis()[i][j] = len;
                        //更新前驱顶点
                        graph.getPre()[i][j] = graph.getPre()[k][j];
                    }
                }
            }
        }
    }
}
