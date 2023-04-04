package com.tzuxin.datastructures.search;

/**
 * 差值查找
 */
public class DifferenceSearch {
    public static int differenceSearch(int[] arr, int left, int right, int num) {
        if (left > right || num < arr[left] || num > arr[right]) {
            return -1;
        }
        int mid = left+(right-left)*(num-arr[left])/(arr[right]-arr[left]);
        if (num == arr[mid]) {
            return mid;
        } else if (num > arr[mid]) {
            return differenceSearch(arr, mid + 1, right, num);
        } else {
            return differenceSearch(arr, left, mid -1, num);
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1,5,6,8,9,10,12,53,66,100,101,108,200,1333,1444,1555,1666,1777,1888};
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int i = DifferenceSearch.differenceSearch(arr, 0, arr.length - 1, 19);
        System.out.println(i);
    }
}
