package com.tzuxin.datastructures.recurrence;

import java.util.Arrays;

/**
 * 递归解决迷宫问题
 */
public class Maze {
    // 0: 未走过  1: 墙  2: 走过  3: 走不通
    int[][] map = new int[8][7];

    public Maze(){
        // 创建一个迷宫 0是路 1是墙壁 2是走的路

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("原始迷宫：");
        this.toString();
//        1  1  1  1  1  1  1
//        1  0  0  0  0  0  1
//        1  0  0  0  0  0  1
//        1  1  1  0  0  0  1
//        1  0  0  0  0  0  1
//        1  0  0  0  0  0  1
//        1  0  0  0  0  0  1
//        1  1  1  1  1  1  1

        System.out.println("递归后：");
        setWay(map, 1, 1);
        this.toString();
//        1  1  1  1  1  1  1
//        1  2  0  0  0  0  1
//        1  2  2  2  0  0  1
//        1  1  1  2  0  0  1
//        1  0  0  2  0  0  1
//        1  0  0  2  0  0  1
//        1  0  0  2  2  2  1
//        1  1  1  1  1  1  1
    }
    public boolean setWay(int[][] map, int i, int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                // 把当前的点标记为走过
                map[i][j] = 2;
                // 按照下->右->左->上的顺序尝试
                if (setWay(map, i+1, j)){
                    return true;
                }else if (setWay(map, i, j+1)){
                    return true;
                }else if (setWay(map, i-1, j)){
                    return true;
                } else if (setWay(map, i, j-1)) {
                    return true;
                }else {
                    map[i][j] = 3;
                }
            }
            return false;
        }
    }

    @Override
    public String toString() {
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
        return "Maze{" +
                "map=" + Arrays.toString(map) +
                '}';
    }

    public static void main(String[] args) {
        new Maze();
    }
}
