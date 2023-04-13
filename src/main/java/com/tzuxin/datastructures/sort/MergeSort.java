package com.tzuxin.datastructures.sort;

import java.util.Arrays;

/**
 * @author chenzixin
 */
public class MergeSort {
    /**
     * 归并排序
     * @param arr 待排序数组
     * @param left 左侧下标
     * @param right 右侧下标
     * @param temp 临时变量数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            // 左侧递归传入
            mergeSort(arr, left, mid, temp);
            // 右侧递归传入
            mergeSort(arr, mid + 1, right, temp);
            // 排序
            merge(arr, left, right, mid, temp);
        }
    }

    /**
     *
     * @param arr 待排序数组
     * @param left 左侧下标
     * @param right 右侧下标
     * @param mid 中间节点下标
     * @param temp 临时变量
     */
    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid || j <= right) {
            if (j > right || (i <= mid && arr[i] <= arr[j]) ) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }

        // 拷贝到原来的数组里
        index  = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[index];
            tempLeft++;
            index++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,1,2,3,4};
        int[] temp = new int[arr.length];
        MergeSort.mergeSort(arr, 0, 7, temp);
        System.out.println(Arrays.toString(arr));
    }
}
