package com.tzuxin.datastructures.tree.threadedbinarytree;

/**
 * 线索二叉树
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        // 手动创建
        ThreadedBinaryTree tree = new ThreadedBinaryTree();

        TreeNode root = new TreeNode(1, "1");
        TreeNode n3 = new TreeNode(3, "1");
        TreeNode n6 = new TreeNode(6, "1");
        TreeNode n8 = new TreeNode(8, "1");
        TreeNode n10 = new TreeNode(10, "1");
        TreeNode n14 = new TreeNode(14, "1");
        root.setLeft(n3);
        root.setRight(n6);
        n3.setLeft(n8);
        n3.setRight(n10);
        n6.setLeft(n14);

        tree.setRoot(root);
        tree.threadedNodes();
        tree.treeList();
    }
}

/**
 * 树的节点
 */
class TreeNode {
    private int no;
    private String data;
    private TreeNode left;
    private TreeNode right;
    // 左右所指的类型，0表示为左/右树，1表示为前驱/后继节点
    private int leftType;
    private int rightType;

    public TreeNode(int no, String data) {
        this.no = no;
        this.data = data;
    }


    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", data='" + data + '\'' +
                '}';
    }
}

/**
 * 中序线索二叉树
 */
class ThreadedBinaryTree {
    private TreeNode root;
    // 记录上一个节点，方便设置后继节点
    private TreeNode pre = null;

    /**
     * 线索化二叉树
     */
    public void threadedNodes(){
        this.threadedNodes(root);
    }
    /**
     * 线索化二叉树
     *
     * @param node 线索化的节点
     */
    public void threadedNodes(TreeNode node) {
        if (node == null) {
            return;
        }
        // 左子树
        this.threadedNodes(node.getLeft());
        // 线索化当前节点
        // 前驱节点
        if (node.getLeft() == null) {
            node.setLeft(this.pre);
            node.setLeftType(1);
        }

        // 后继节点，这里是在需要设置的节点的后继节点上进行操作的
        // 例如数组{8,13...}的8需要在遍历到13时进行设置
        if (pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;
        // 右子树
        this.threadedNodes(node.getRight());
    }

    /**
     * 设置树的根节点
     *
     * @param root 根节点
     */
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 遍历
     */
    public void treeList(){
        TreeNode node = root;
        while (node != null){
            // 拿到中序排序第一个节点
            while (node.getLeftType() != 1){
                node = node.getLeft();
            }
            // 拿到后输出当前节点
            System.out.println(node);
            while (node.getRightType() == 1){
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
}
