package com.tzuxin.datastructures.sort;

import java.util.Arrays;

public class InsertionSort {
    /**
     * 插入排序
     * @param arr 待排序数组
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,3,2,9,0};
        InsertionSort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
