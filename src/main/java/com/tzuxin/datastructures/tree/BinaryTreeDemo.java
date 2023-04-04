package com.tzuxin.datastructures.tree;

/**
 * 二叉树
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode node1 = new TreeNode(1, "test1");
        TreeNode node2 = new TreeNode(2, "test2");
        TreeNode node3 = new TreeNode(3, "test3");
        TreeNode node4 = new TreeNode(4, "test4");
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        tree.setRoot(node1);

//        System.out.println(tree.preSearch(4));
//        tree.postOrder();

        BinaryTree tree1 = new BinaryTree();
        TreeNode n1 = new TreeNode(1, "test1");
        TreeNode n2 = new TreeNode(3, "test2");
        TreeNode n3 = new TreeNode(6, "test3");
        TreeNode n4 = new TreeNode(8, "test4");
        TreeNode n5 = new TreeNode(10, "test3");
        TreeNode n6 = new TreeNode(14, "test4");
        n3.setLeft(n6);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n1.setLeft(n2);
        tree1.setRoot(n1);
        tree1.midOrder();
    }
}

/**
 * 二叉树
 */
class BinaryTree{
    private TreeNode root;

    /**
     * 设置树的根节点
     * @param root 根节点
     */
    public void setRoot(TreeNode root) {
        this.root = root;
    }
    public TreeNode preSearch(int no){
        return this.root.preSearch(no);
    }
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }
    }

    public void midOrder(){
        if (this.root != null){
            this.root.midOrder();
        }
    }

    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }
    }
}

/**
 * 树的节点
 */
class TreeNode{
    private int no;
    private String data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int no, String data) {
        this.no = no;
        this.data = data;
    }

    /**
     * 前序遍历
     */
    public TreeNode preSearch(int no){
        // 中 左 右的顺序输出
        // 输出中间节点
        if (this.getNo() == no){
            return this;
        }
        // 输出左边节点
        if (this.left != null){
            TreeNode treeNode = this.left.preSearch(no);
            if (treeNode != null){
                return treeNode;
            }
        }
        // 输出右边节点
        if (this.right != null){
            TreeNode treeNode = this.right.preSearch(no);
            if (treeNode != null){
                return treeNode;
            }
        }
        return null;
    }
    /**
     * 前序遍历
     */
    public void preOrder(){
        // 中 左 右的顺序输出
        // 输出中间节点
        System.out.println(this);
        // 输出左边节点
        if (this.left != null){
            this.left.preOrder();
        }
        // 输出右边节点
        if (this.right != null){
            this.right.preOrder();
        }
    }
    /**
     * 中序遍历
     */
    public void midOrder(){
        // 左 中 右的顺序输出
        // 输出左边节点
        if (this.left != null){
            this.left.midOrder();
        }
        // 输出中间节点
        System.out.println(this);
        // 输出右边节点
        if (this.right != null){
            this.right.midOrder();
        }
    }
    /**
     * 后序遍历
     */
    public void postOrder(){
        // 左 右 中的顺序输出
        // 输出左边节点
        if (this.left != null){
            this.left.postOrder();
        }
        // 输出右边节点
        if (this.right != null){
            this.right.postOrder();
        }
        // 输出中间节点
        System.out.println(this);
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