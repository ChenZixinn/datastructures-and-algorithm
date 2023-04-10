package com.tzuxin.algorithm.dynamic;

import com.tzuxin.algorithm.dynamic.entity.Goods;

/**
 * @author chenzixin
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        Goods[] goods = new Goods[]{
                new Goods("吉他(G)", 1, 1500),
                new Goods("音响(S)", 4, 3000),
                new Goods("电脑(L)", 3, 2000)
        };
        knapsackProblem(4, goods);
    }

    /**
     * @param capacity 背包容量
     * @param goods 背包列表
     */
    public static void knapsackProblem(int capacity, Goods[] goods) {
        // 从0-capacity的列表。如果是4磅，列表里存放[0,1,2,3,4]，用于比对
        int[] w = new int[capacity+1];
        for (int i = 0; i < w.length; i++) {
            w[i] = i;
        }

        // 第一行第一列都是0，所以长度要+1。存放最后的结果
        int[][] v = new int[goods.length + 1][capacity + 1];
        // 置0（默认为0）
//        for (int i = 0; i < v.length; i++) {
//            v[i][0] = 0;
//        }
//        for (int j = 0; j < v[0].length; j++) {
//            v[0][j] = 0;
//        }

        // 开始动态算法
        // 从1开始，因为第一列都是0
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                // 判断是否能装下当前的good
                if (goods[i - 1].getWeight() > w[j]) {
                    // 装不下就用上一次的值
                    v[i][j] = v[i-1][j];
                }else {
                    // 当准备装入的商品重量小于等于当前背包容量时（装得下或者装下后还有剩余空间），在以下选项中选出最大
                    //1）v[i-1][j] （上一个单元格的装入的最大值）
                    //2）goods[i - 1].value （表示当前商品的价值） +  v[i-1][j-goods[i - 1].weight]：（除掉当前商品的重量，还能装下的最大价值）
                    v[i][j] = Math.max(v[i-1][j], goods[i - 1].getValue() + v[i-1][j-goods[i - 1].getWeight()]);
                }
            }
        }

        // 打印信息
        for (int i : w) {
            System.out.print(i + "磅\t");
        }
        System.out.println();
        for (int[] v1 : v) {
            for (int i : v1) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}

