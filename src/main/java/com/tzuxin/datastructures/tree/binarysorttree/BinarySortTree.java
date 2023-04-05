package com.tzuxin.datastructures.tree.binarysorttree;

import javax.lang.model.element.VariableElement;
import java.awt.print.PrinterAbortException;

public class BinarySortTree {
    // 测试
    public static void main(String[] args) {
        int arr[] = {7,3,10,12,5,1,9,2};
        /*
        *              7
        *       3           10
        *    1     5     9     12
        *      2
        * */
//        int arr[] = {1};
        BinarySortTree bst = new BinarySortTree();
        for (int value : arr) {
            bst.add(new Node(value));
        }
        bst.del(10);
        bst.midOrder();
    }
    Node root;

    /**
     * 查找value对应的Node
     * @param value Node的值
     * @return Node对象，找不到返回null
     */
    public Node searchNode(int value) {
        return root.searchNode(value);
    }

    /**
     * 查找对应元素的节点及其父节点
     * @param val Node的value
     * @return 父节点Node,找不到返回null
     */
    public Node searchParent(int val){
        return root.searchParent(val);
    }

    /**
     * 删除节点
     * @param value 要删除的节点的值
     */
    public void del(int value){
        if (root == null){
            return;
        }
        Node parent = null;
        Node target = null;
        // 找节点和它的父节点
        if (root.value == value){
            //要删除的是root节点
            target = root;
        }else {
            // 拿到节点和父节点
            Node[] nodes = root.searchNodeAndParent(value);
            if (nodes != null){
                parent = nodes[0];
                target = nodes[1];
            }else {
                return ;
            }
        }

        //三种情况
        // 1、要删除的节点是叶子节点
        if (target.left == null && target.right == null){
            if (parent.left != null && parent.left.value == target.value){
                parent.left = null;
            }else {
                parent.right = null;
            }
//            target = null;
        }else if(target.left == null || target.right == null){
            // 2、要删除的节点只有一颗子树
            Node temp;
            // 判断删除目标的左还是右侧有子树
            if (target.left != null){
                temp = target.left;
            }else {
                // 右侧
                temp = target.right;
            }
            if (parent.left != null && parent.left.value == target.value){
                parent.left = temp;
            }else {
                parent.right = temp;
            }
            target = null;
        }else {
            // 3、要删除的节点有两颗子树
//            找到目标节点右侧的最小节点，用来替换掉目标节点
            Node minNode = target.right;
            while (minNode.left != null){
                minNode = minNode.left;
            }
            // 保存后先删掉这个节点
            del(minNode.value);

            // 替换掉要删除的节点
            if (parent.left != null && parent.left.value == target.value){
                parent.left = minNode;
            }else {
                parent.right = minNode;
            }
            // 把删除的节点的左右赋值给新的节点
            // 可能存在null的情况，需要判断
            if (target.left != null){
                minNode.left = target.left;
            }
            if (target.right != null){
                minNode.right = target.right;
            }
        }
    }

    /**
     * 添加节点
     * @param node 要新增的节点
     */
    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    private void midOrder() {
        root.midOrder();
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 查找value对应的Node
     * @param value Node的值
     * @return Node对象，找不到返回null
     */
    public Node searchNode(int value) {
        if (this.value == value){
            return this;
        }
        if (value < this.value && this.left != null){
            return this.left.searchNode(value);
        } else if (value >= this.value && this.right != null) {
            return this.right.searchNode(value);
        }else{
            return null;
        }
    }

    /**
     * 查找对应元素的节点及其父节点
     * @param val Node的value
     * @return 父节点Node,找不到返回null
     */
    public Node searchParent(int val){
        if ((this.left != null && this.left.value == val)||(this.right != null && this.right.value == val)){
            return this;
        }else{
            if (val < this.value && this.left != null){
                return this.left.searchParent(val);
            } else if (val >= this.value && this.right != null) {
                return this.right.searchParent(val);
            }else{
                return null;
            }
        }
    }

    public Node[] searchNodeAndParent(int val){
        if (this.left != null && this.left.value == val){
            return new Node[]{this, this.left};
        }else if(this.right != null && this.right.value == val){
            return new Node[]{this, this.right};
        }else{
            if (val < this.value && this.left != null){
                return this.left.searchNodeAndParent(val);
            } else if (val >= this.value && this.right != null) {
                return this.right.searchNodeAndParent(val);
            }else{
                return null;
            }
        }
    }

    /**
     * 添加节点
     * @param node 节点
     */
    public void add(Node node){
        if (node == null){
            return;
        }
        // 小于当前节点的放左边
        if (node.value < this.value){
            // 如果当前左边没有节点，即可放入
            if (this.left == null){
                this.left = node;
            }else {
                //否则递归向左查找
                this.left.add(node);
            }
        }else{
            // 大于当前节点的放右边
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void midOrder(){
        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.midOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}