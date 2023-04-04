package com.tzuxin.datastructures.tree;

/**
 * 顺序存储二叉树
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tr = new ArrayBinaryTree(arr);
        tr.preOrder();
    }
}

/**
 * 顺序存储二叉树
 */
class ArrayBinaryTree{
    int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }
    public void midOrder(){
        this.midOrder(0);
    }
    public void postOrder(){
        this.postOrder(0);
    }

    /**
     * 前序遍历树
     * @param index 根节点的下标
     */
    public void preOrder(int index){
        // 判断是否为空
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        System.out.println(arr[index]);
        // 向左递归
        if ((2 * index + 1) < arr.length){
            preOrder(2 * index + 1);
        }
        // 向右递归
        if ((2 * index + 2) < arr.length){
            preOrder(2 * index + 2);
        }
    }
    /**
     * 中序遍历树
     * @param index 根节点的下标
     */
    public void midOrder(int index){
        // 判断是否为空
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        // 向左递归
        if ((2 * index + 1) < arr.length){
            midOrder(2 * index + 1);
        }
        System.out.print(arr[index] + " ");
        // 向右递归
        if ((2 * index + 2) < arr.length){
            midOrder(2 * index + 2);
        }
    }
    /**
     * 后序遍历树
     * @param index 根节点的下标
     */
    public void postOrder(int index){
        // 判断是否为空
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        // 向左递归
        if ((2 * index + 1) < arr.length){
            postOrder(2 * index + 1);
        }
        // 向右递归
        if ((2 * index + 2) < arr.length){
            postOrder(2 * index + 2);
        }
        System.out.println(arr[index]);
    }
}
