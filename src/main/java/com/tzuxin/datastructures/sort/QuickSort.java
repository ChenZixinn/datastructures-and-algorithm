package com.tzuxin.datastructures.sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author chenzixin
 */
public class QuickSort {
    /**
     * 快速排序实现
     * @param arr 待排序数组
     * @param low 数组左侧下标
     * @param high 右侧下标
     */
    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            // 指向交换后的中心点坐标
            int pointer = low;
            // 当前对比的元素，小的在左，大的在右
            int pivot = arr[high];
            // 循环当前数组段
            for (int i = low; i < high; i++) {
                // 大于中心的往右放
                if (arr[i] <= pivot){
                    int temp = arr[i];
                    arr[i] = arr[pointer];
                    arr[pointer] = temp;
                    pointer++;
                }
            }
            // 把基准数放到中心
            arr[high] = arr[pointer];
            arr[pointer] = pivot;
            // 递归
            quickSort(arr, low, pointer - 1);
            quickSort(arr, pointer + 1, high);

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,1,0,1,4,6,8,2,10,11};
        QuickSort.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
