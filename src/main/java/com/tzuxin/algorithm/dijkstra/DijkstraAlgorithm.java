package com.tzuxin.algorithm.dijkstra;

import javax.lang.model.element.VariableElement;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * dijkstra算法解决最短路径问题
 * @author chenzixin
 */
public class DijkstraAlgorithm {
    public static void main(String[] args) {
        char[] vertexes =  {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int N = 65535;
        int[][] matrix = {
                {N,5,7,N,N,N,2},
                {5,N,N,9,N,N,3},
                {7,N,N,N,8,N,N},
                {N,9,N,N,N,4,N},
                {N,N,8,N,N,5,4},
                {N,N,N,4,5,N,6},
                {2,3,N,N,4,6,N}
        };
        Graph graph = new Graph(vertexes, matrix);
        graph.showMatrix();

        DijkstraAlgorithm dij = new DijkstraAlgorithm();
        dij.dijkstraAlgorithm(graph, 6);
        dij.showRes();
    }
    VisitedVertex vv;
    Graph graph;
    /**
     *
     * @param graph 图的实例
     * @param index 出发顶点对应的下标
     */
    public void dijkstraAlgorithm(Graph graph, int index){
        this.graph = graph;
        vv = new VisitedVertex(graph.getVertexes().length, index);
        // 更新index节点到周围节点的前驱和最短距离
        update(index);
        for (int i = 1; i < this.graph.getVertexes().length; i++) {
            // 选择并返回新的访问节点(上一次遍历后路径最短的合适节点)
            index = vv.updateArr();
            update(index);
        }
    }

    /**
     * 更新index顶点到周围顶点的距离和周围顶点的前驱顶点
     * @param index 顶点下标
     */
    private void update(int index){
        int len;
        for(int j = 0; j < this.graph.getMatrix()[index].length; j++) {
            // 获取最新的路径：起点到达该节点的最短路径 + 当前节点到达该节点的路径
            len = vv.getDisByIndex(index) + this.graph.getMatrix()[index][j];
            // 如果该节点还没更新过 且 拿到的路径小于已经存在的路径
            if(!vv.isAlready(j) && len < vv.getDisByIndex(j)) {
                // 更新父节点
                vv.updatePre(j, index);
                // 更新结果数组
                vv.updateDis(j, len);
            }
        }
    }

    public void showRes(){
        System.out.println("最短路径：");
        for (int i = 0; i < vv.getDis().length; i++) {
            System.out.print(this.graph.getVertexes()[i]  + "("  + this.vv.getDis()[i] + ") ");
        }
//        System.out.println(Arrays.toString(this.vv.getDis()));
        System.out.println();
        System.out.println("前驱节点：");
        System.out.println(Arrays.toString(this.vv.getPreVisited()));
        System.out.println("已访问过的数组：");
        System.out.println(Arrays.toString(this.vv.getAlreadyArr()));
    }
}
