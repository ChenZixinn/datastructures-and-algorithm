package com.tzuxin.datastructures;


import com.tzuxin.datastructures.sort.InsertionSort;
import com.tzuxin.datastructures.sort.ShellSort;

import java.sql.Time;

public class Test {
    // test
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = i;
        }
        arr[99999] = 1;
        long startTime = System.currentTimeMillis();
        ShellSort.shellSort(arr);
        // 执行代码
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序运行时间：" + (endTime - startTime) + "ms");


    }
}
