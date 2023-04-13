package com.tzuxin.datastructures.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param arr 数组
     */
    public static void bubbleSort(int[] arr){
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    // 交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag){
                System.out.println("输入的数组已为排序好的数组");
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,6,2,9,3,8,4,0,5,11,7};
        BubbleSort.bubbleSort(arr);
        for (int i : arr) {
            System.out.println("排序后：");
            System.out.print(i + " ");
        }
    }
}
