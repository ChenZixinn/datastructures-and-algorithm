package com.tzuxin.datastructures.sort;

/**
 * 选择排序
 */
public class SelectSort {
    public static void selectSort(int[] arr){
        int index;
        int min;
        for (int i = 0; i < arr.length; i++) {
            // 记录最小的数
            min = arr[i];
            // 用于记录最小数的下标
            index = -1;
            for (int j = i+1; j < arr.length; j++) {
                // 找到更小的数，先进行标记
                if (arr[j] < min){
                    index = j;
                    min = arr[j];
                }
            }
            // 如果有找到更小的数就进行交换
            if (index != -1){
                // 交换位置
                int temp = arr[i];
                arr[i] = min;
                arr[index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,6,2,7,3};
        SelectSort.selectSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
