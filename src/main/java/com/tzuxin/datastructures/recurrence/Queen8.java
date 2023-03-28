package com.tzuxin.datastructures.recurrence;

/**
 * 解决八皇后问题
 */
public class Queen8 {
    int max = 8;
    // 定义数组，保存皇后放置位置的结果，比如arr={0, 4, 7, 5, 2, 6, 1, 3}
    int[] arr = new int[max];
    int count = 0;

    public void check(int n){
        if (n == max){
            print();
            count ++;
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)){
                check(n + 1);
            }
        }
    }

    /**
     * 判断是否与之前放置的皇后冲突
     * @param n
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            // 1、如果在同一列
            // 2、如果在同一斜线
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public void print(){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("总共有："+queen8.count);
    }
}
