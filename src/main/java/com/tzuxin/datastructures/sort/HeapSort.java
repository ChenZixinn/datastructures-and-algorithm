package com.tzuxin.datastructures.sort;

import java.sql.Array;
import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9,-1,-5,100,13,7};
        HeapSort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 升序排序
     *
     * @param arr 要排序的数组
     */
    public static void heapSort(int[] arr) {
        int temp = 0;
        // 先进行第一次调整，确保是大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length-1; j > 0; j--) {
            // 把顶上的最大元素调整到最后一个叶子节点上，且不再移动
            temp = arr[j] ;
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 把数组(二叉树)调整为大顶堆
     * @param arr 要调整的数组
     * @param i   非叶子节点的下标
     * @param len 要调整多少个元素(len会逐渐减少)
     */
    public static void adjustHeap(int[] arr, int i, int len) {
        int temp = arr[i];
        // 从i指向的节点往下遍历，把大的树移动到上面
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
            // 指向左右子树中大的元素
            if (j + 1 < len && arr[j] < arr[j + 1]) {
                j++;
            }
            // 如果左/右子树的值大于i指向的元素，则进行交换。
            if (arr[j] > temp) {
                arr[i] = arr[j];
                // 交换下标位置，让i指向下面的树
                i = j;
            } else {
                // 如果小于，代表后面的节点已经排序好了，退出
                break;
            }
        }
        // 最后再把temp保存的值替换到最后交换的元素上
        arr[i] = temp;
    }
}
