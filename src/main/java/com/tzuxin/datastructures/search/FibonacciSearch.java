package com.tzuxin.datastructures.search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;

    /**
     * 获取斐波那契数组
     * @return 斐波那契数组
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     *
     * @param arr 数组
     * @param key 查找的值
     * @return 目标的下标
     */
    public static int fibSearch(int[] arr, int key) {
        // fib数组下标
        int k = 0;
        // 数组左侧
        int low = 0;
        // 数组右侧
        int high = arr.length - 1;
        // 分割点
        int mid = 0;
        // fib数组
        int[] f = fib();
        // 找到足够的数据
        while (high > f[k] - 1) {
            k++;
        }
        // 原始数组可能不够长，扩展
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 8, 14, 16, 20, 22, 24};
        System.out.println(FibonacciSearch.fibSearch(arr, 3));
    }
}
