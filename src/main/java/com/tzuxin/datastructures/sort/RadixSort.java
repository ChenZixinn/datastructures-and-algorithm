package com.tzuxin.datastructures.sort;

import java.util.Arrays;

/**
 * 基数排序
 * @author chenzixin
 */
public class RadixSort {
    /**
     * 基数排序
     * @param arr 待排序数组
     */
    public static void radixSort(int[] arr) {
        // 拿到最大的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxSize = (max + "").length();

        // 桶
        int[][] bucket = new int[10][arr.length];
        // 记录bucket数组里存放的元素个数
        int[] bucketSize = new int[10];

        for (int k = 0; k < maxSize; k++) {
            for (int i = 0; i < arr.length; i++) {
                // 每次循环取不同的位
                int digit = arr[i] / (int)Math.pow(10,k) % 10;
                // 存放到对应桶的数组中，++的是元素的有效个数
                bucket[digit][bucketSize[digit]++] = arr[i];
            }
            int index = 0;
            // 把数据从桶取回数组
            for (int i = 0; i < bucketSize.length; i++) {
                if (bucketSize[i] != 0) {
                    for (int j = 0; j < bucketSize[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }
                bucketSize[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        RadixSort.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
