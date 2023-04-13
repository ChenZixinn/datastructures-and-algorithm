package com.tzuxin.algorithm.dijkstra;

import lombok.Data;

import java.util.Arrays;

/**
 * 已访问顶点集合
 * @author chenzixin
 */
@Data
public class VisitedVertex {
    /**
     * 记录各个顶点是否访问过，1表示访问过，0表示未访问
     */
    private int[] alreadyArr;
    /**
     * 每个下标对应的值为前一个顶点下标
     */
    private int[] preVisited;
    /**
     * 记录出发点到其他顶点的距离
     */
    private int[] dis;

    /**
     * 构造函数
     * @param length 顶点的个数
     * @param index 要查询的顶点的下标
     */
    public VisitedVertex(int length, int index) {
        this.alreadyArr = new int[length];
        this.preVisited = new int[length];
        Arrays.fill(preVisited, -1);
        this.dis = new int[length];
        // 初始化dis数组
        this.alreadyArr[index] = 1;
        Arrays.fill(dis, 65535);
        this.dis[index] = 0;
    }

    /**
     * 判断顶点是否访问过
     * @param index 顶点下标
     * @return true：访问过返回，false：没访问过返回
     */
    public boolean isAlready(int index){
        return this.alreadyArr[index] == 1;
    }

    /**
     * 更新顶点到节点的最短路径
     * @param index 目标节点
     * @param len 长度
     */
    public void updateDis(int index, int len){
        this.dis[index] = len;
    }

    /**
     * 更新前驱节点
     * @param pre 节点的index
     * @param index 前驱节点的index
     */
    public void updatePre(int pre, int index){
        this.preVisited[pre] = index;
    }

    /**
     * 返回出发顶点到index顶点的最短路径
     * @param index 目的顶点
     * @return 最短路径
     */
    public int getDisByIndex(int index){
        return this.dis[index];
    }

    /**
     * 根据最短路径继续返回新的访问节点
     * @return 新的节点的下标
     */
    public int updateArr() {
        int min = 65535, index = 0;
        for(int i = 0; i < this.alreadyArr.length; i++) {
            if(this.alreadyArr[i] == 0 && dis[i] < min ) {
                min = dis[i];
                index = i;
            }
        }
        this.alreadyArr[index] = 1;
        return index;
    }


}
