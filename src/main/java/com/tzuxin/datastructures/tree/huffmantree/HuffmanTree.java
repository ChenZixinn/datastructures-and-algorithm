package com.tzuxin.datastructures.tree.huffmantree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = HuffmanTree.createHuffmanTree(arr);
        HuffmanTree.preOrder(root);
    }

    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }
    }

    /**
     * 构建哈夫曼树
     * @param arr 要构建哈夫曼树的数组
     */
    public static Node createHuffmanTree(int[] arr){
        ArrayList<Node> nodes = new ArrayList<>();
        // 遍历将Node放入数组
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        // 当剩下最后一个节点时即为完成
        while (nodes.size() > 1){
            // 排序
            // node实现了comparable接口
            Collections.sort(nodes);
            // 取出数组第一个和第二个节点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            // 删除原来的节点，加入新的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        // 此处的节点即为哈夫曼树
        return nodes.get(0);
    }
}

class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 升序排序
        return this.value - o.value;
    }
}
