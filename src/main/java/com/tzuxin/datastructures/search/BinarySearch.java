package com.tzuxin.datastructures.search;

/*
二分查找
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int left, int right, int num) {
        if (left > right) {
            return -1;
        }
        System.out.println("1");

        int mid = (left + right) / 2;
        if (num == arr[mid]) {
            return mid;
        } else if (num > arr[mid]) {
            return binarySearch(arr, mid + 1, right, num);
        } else {
            return binarySearch(arr, left, mid -1, num);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,6,8,9,10,12,53,66,100,101,108,200,1333,1444,1555,1666,1777,1888};
        int i = BinarySearch.binarySearch(arr, 0, arr.length - 1, 1666);
        System.out.println(i);
    }
}
