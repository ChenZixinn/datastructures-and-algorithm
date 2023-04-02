package com.tzuxin.datastructures.queue;

/**
 * 循环队列
 */
public class CircleArrayList {
    int front;
    int rear;
    int[] arr;
    int maxSize;

    /**
     * 构造函数
     * @param maxSize 队列长度
     */
    public CircleArrayList(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断是否为空
     * @return true为空，false为否
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 判断是否已经满了
     * @return true满，false未满
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    /**
     * 返回队列里元素的个数
     * @return 元素个数
     */
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 把元素放进队列里
     * @param n 要放进来的元素
     */
    public void put(int n){
        // 判断是否已经满了
        if (isFull()){
            System.out.println("队列满了");
            return;
        }
        // 把数据放在rear指向的位置
        arr[rear] = n;
//        rear往前移动
        rear = (rear + 1) % maxSize;
    }

    /**
     * 返回队列元素
     * @return 队列元素
     */
    public int get(){
        // 获取到front指向的元素
        int val = arr[front];
        // front往前移动
        front = (front + 1) % maxSize;
        return val;
    }

    /**
     * 遍历数组，打印出每个元素
     */
    public void showQueue(){
        for (int i = front; i <= size(); i++) {
            System.out.println("arr[" + i % maxSize + "] = " + arr[i % maxSize]);
        }
    }

    public static void main(String[] args) {
        CircleArrayList circleArrayList = new CircleArrayList(10);
        circleArrayList.put(1);
        circleArrayList.put(2);
        circleArrayList.put(3);
        circleArrayList.put(4);
        circleArrayList.put(5);
        circleArrayList.put(6);
        circleArrayList.put(7);
        circleArrayList.put(8);
        circleArrayList.put(9);
        circleArrayList.put(10);
        System.out.println(circleArrayList.get());
        circleArrayList.put(11);
        circleArrayList.showQueue();
    }
}
