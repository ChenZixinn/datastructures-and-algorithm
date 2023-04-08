package com.tzuxin.algorithm.divideandconquer;

/**
 * 分治算法：解决汉诺塔问题
 * @author chenzixin
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(3,'A', 'B', 'C');
    }

    public static void hanoiTower(int num, char a, char b, char c){
        if (num <= 1){
            System.out.println("从" + a + " -> " + c);
        }else {
            // 把最上面的盘都移动到缓冲盘(a上面的盘都移动到b，然后才能放到c上)
            hanoiTower(num - 1, a, c, b);
            // 2、最底下的盘可以移动了
            System.out.println("从" + a + " -> " + c);
            // 3、继续把没移动完的盘进行移动(b移动到c，用a做缓冲)
            hanoiTower(num - 1, b, a, c);
        }
    }
}
