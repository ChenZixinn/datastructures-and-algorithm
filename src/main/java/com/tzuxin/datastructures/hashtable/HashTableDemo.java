package com.tzuxin.datastructures.hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable(10);
        myHashTable.add(new Employee(1, "chen1"));
        myHashTable.add(new Employee(2, "chen2"));
        myHashTable.add(new Employee(3, "chen3"));
        myHashTable.add(new Employee(4, "chen4"));
        myHashTable.add(new Employee(5, "chen5"));
        myHashTable.add(new Employee(6, "chen6"));
        myHashTable.add(new Employee(7, "chen7"));
        myHashTable.add(new Employee(8, "chen8"));
        myHashTable.add(new Employee(9, "chen9"));
        myHashTable.add(new Employee(10, "chen10"));
        myHashTable.add(new Employee(11, "chen11"));
        myHashTable.add(new Employee(12, "chen12"));
        myHashTable.add(new Employee(13, "chen13"));
        myHashTable.del(12);
        myHashTable.show();

        Employee employee = myHashTable.find(13);
        System.out.println(employee.id);

    }
}
class MyHashTable{
    EmployeeLinkedList[] empLinkedListArray;
    int size;

    /**
     * 构造链表数组
     * @param size 数组长度
     */
    public MyHashTable(int size) {
        this.size = size;
        this.empLinkedListArray = new EmployeeLinkedList[size];
        for (int i = 0; i < this.empLinkedListArray.length; i++) {
            this.empLinkedListArray[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee emp){
        int ind = hashFun(emp.id);
        empLinkedListArray[ind].add(emp);
    }
    public Employee find(int id){
        int ind = hashFun(id);
        return empLinkedListArray[ind].find(id);
    }
    public void del(int id){
        int ind = hashFun(id);
        empLinkedListArray[ind].del(id);
    }
    public void show(){
        for (EmployeeLinkedList empLinkedList : empLinkedListArray) {
            empLinkedList.show();
        }
    }

    /**
     * 计算返回数组下标，即数据应该存放在哪个链表中
     * @return 数组下标
     */
    public int hashFun(int id){
        return id % size;
    }
}
/**
 * 实体类
 */
class Employee {
    public int id;
    public String name;
    public Employee next;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.next = null;
    }

}

/**
 * 链表
 */
class EmployeeLinkedList {
    public static void main(String[] args) {
        EmployeeLinkedList linkedList = new EmployeeLinkedList();
        linkedList.add(new Employee(1,"chen"));
        linkedList.add(new Employee(2,"cai"));
        linkedList.add(new Employee(3,"aiting"));
        System.out.println(linkedList.find(1).name);
    }

    public Employee head;

    public EmployeeLinkedList() {
        this.head = null;
    }

    /**
     * 添加方法，把对象添加到链表的最后
     *
     * @param employee 要添加的对象
     */
    public void add(Employee employee) {
        // 头节点为空添加到头节点
        if (head == null) {
            this.head = employee;
        } else {
            // 添加到链表最后
            Employee cur = head;
            while (true) {
                if (cur.next == null) {
                    cur.next = employee;
                    break;
                }
                cur = cur.next;
            }
        }
    }

    /**
     * 遍历打印链表信息
     */
    public void show() {
        if (head == null) {
            System.out.println("链表为空。");
            return;
        }
        Employee cur = head;
        while (true) {
            System.out.println("==> id:" + cur.id + ", name: " + cur.name);
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
    }

    /**
     * 查找元素
     * @param id 元素id
     * @return 元素对象
     */
    public Employee find(int id){
        // 判断是否为空
        if (head == null) {
            System.out.println("链表为空。");
            return null;
        }
        Employee cur = head;
        while (true) {
            // 循环查找
            if (cur.id == id){
                return cur;
            }
            if (cur.next == null) {
                return null;
            }
            cur = cur.next;
        }
    }

    /**
     * 删除元素
     * @param id 元素id
     * @return 1为成功，-1为失败
     */
    public int del(int id){
        if (head == null) {
            System.out.println("链表为空。");
            return -1;
        }
        // 判断head是不是要删除的元素
        Employee cur = head;
        if (cur.id == id){
            head = head.next;
            return 1;
        }
        while (true) {
            if (cur.next == null){
                break;
            }
            // 判断要删掉的元素
            if (cur.next.id == id){
                // 如果要删掉的是最后一个元素，
                if (cur.next.next == null){
                    cur.next = null;
                }else {
                    // 如果要删掉的节点后面还有节点，则需要把后面的节点挪到当前节点来
                    cur.next = cur.next.next;
                }
                return 1;
            }
            cur = cur.next;
        }
        return -1;
    }
}

