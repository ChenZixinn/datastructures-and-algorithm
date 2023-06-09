package com.tzuxin.datastructures.sort;



import java.util.Arrays;

/**
 * 希尔排序
 * @author chenzixin
 */
public class ShellSort {
    /**
     * 希尔排序
     * @param arr 待排序数组
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        // 根据步长先排序一轮
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 11, 4, 8, 9, 1, 12};
        ShellSort.shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
