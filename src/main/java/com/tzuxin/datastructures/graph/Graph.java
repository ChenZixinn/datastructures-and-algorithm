package com.tzuxin.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    public static void main(String[] args) {
        // 测试
        String[] vertexes = {"1","2","3","4","5","6","7","8"};
        int n = vertexes.length;
        Graph graph = new Graph(n);
        for (String vertex : vertexes) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(4,1,1);
        graph.insertEdge(3,7,1);
        graph.insertEdge(4,7,1);
        graph.insertEdge(2,5,1);
        graph.insertEdge(2,6,1);
        graph.insertEdge(5,6,1);
        System.out.println("深度优先：");
        graph.dfs();
        System.out.println();
        System.out.println("广度优先：");
        graph.bfs();
    }

    private ArrayList<String> vertexList; // 存储顶点集合

    private int[][] edges;  // 存储图对应的邻接矩阵

    private int numOfEdges;
    private boolean[] isVisited;

    public Graph(int size) {
        edges = new int[size][size];
        vertexList = new ArrayList<>(size);
        isVisited = new boolean[size];
    }

    /**
     * 广度优先遍历
     * @param isVisited 是否被访问过的byte[]
     * @param i 下标
     */
    private void dfs(boolean[] isVisited, int i){
        // 先输出当前节点
        System.out.print("=>" + getVertex(i));
        isVisited[i] = true;
        // 找到第一个邻接节点
        int w = getFirstNeighbor(i);
        while (w != -1){
            // 如果这个邻接节点没被访问过，就让他进行遍历
            if (!isVisited[w]){
                dfs(isVisited, w);
            }
            // 让w指向i的下一个邻接节点
            w = getNextNeighbor(i, w);
        }
    }

    /**
     * 对一个节点进行广度优先遍历
     * @param isVisited 是否被访问过的byte[]
     * @param i 下标
     */
    private void bfs(boolean[] isVisited, int i){
        int u;  // 队列头节点的下标
        int w;  // 邻接节点
        // 队列
        LinkedList<Integer> queue = new LinkedList<>();
        // 输出当前节点
        System.out.print("=>" + getVertex(i));
        // 标记为已访问
        isVisited[i] = true;
        // 把节点加入队列
        queue.addLast(i);
        // 队列非空就一直运行
        while (!queue.isEmpty()){
            u = queue.removeFirst();
            // 找到u的第一个邻接点
            w = getFirstNeighbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    // 输出这个节点
                    System.out.print("=>" + getVertex(w));
                    // w入队
                    queue.addLast(w);
                    // 标记为已访问
                    isVisited[w] = true;
                }
                // 找u在w之后的节点
                w = getNextNeighbor(u, w);
            }
        }
    }

    /**
     * 广度优先遍历
     */
    public void bfs(){
        isVisited = new boolean[isVisited.length];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }
    /**
     * 深度优先遍历
     */
    public void dfs(){
        isVisited = new boolean[isVisited.length];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 得到第一个相邻节点
     * @param index 要获得相邻节点的下标
     * @return 相邻节点的下标
     */
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0 && i != index){
                return i;
            }
        }
        return -1;
    }

    /**
     * 得到下一个相邻节点
     * @param index 要获得相邻节点的下标
     * @param oldIndex 已经访问过了的节点的下标
     * @return 下一个相邻节点的下标
     */
    public int getNextNeighbor(int index, int oldIndex){
        for (int i = oldIndex+1; i < vertexList.size(); i++) {
            if (edges[index][oldIndex] > 0 && i != index){
                return i;
            }
        }
        return -1;
    }



    /**
     * 返回边的数量
     * @return 边的数量
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }

    /**
     * 返回节点的数量
     * @return 节点的数量
     */
    public int getNumOfVertex(){
        return vertexList.size();
    }

    /**
     * 根据index返回节点的数据
     * @param i 节点的index
     * @return 节点的数据
     */
    public String getVertex(int i){
        return this.vertexList.get(i);
    }

    /**
     * 返回v1 -> v2对应的权值
     * @param v1 下标值
     * @param v2 下标值
     * @return weight权重
     */
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    /**
     * 输出图
     */
    public void showGraph(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
    /**
     * 添加节点
     * @param vertex 节点的字符串
     */
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1 要连接的节点的下标
     * @param v2 要连接的节点的下标
     * @param weight 权值，建议1，默认0代表无
     */
    public void insertEdge(int v1, int v2, int weight){
        this.edges[v1][v2] = weight;
        this.edges[v2][v1] = weight;
        this.numOfEdges++;
    }
}
