package com.tzuxin.datastructures.queue;

/**
 * 循环队列
 */
public class CircleArrayList {
    int front;
    int rear;
    int[] arr;
    int maxSize;

    public CircleArrayList(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public void put(int n){
        if (isFull()){
            System.out.println("队列满了");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int get(){
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }

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
