package com.tzuxin.algorithm.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,5,6,9,10,15,22,29,100,101,103};
        System.out.println(BinarySearch.binarySearch(arr, 103));
    }

    /**
     * 二分查找非递归的方法
     * @param arr 要查找的数组
     * @param target 查找的目标
     * @return 目标在数组中的下标
     */
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left<=right){
            mid = (right + left) / 2;
            if (arr[mid] == target){
                return mid;
            } else if (target < arr[mid]) {
                right = mid-1;
            }else if (target > arr[mid]){
                left = mid+1;
            }
        }
        return -1;
    }
}
