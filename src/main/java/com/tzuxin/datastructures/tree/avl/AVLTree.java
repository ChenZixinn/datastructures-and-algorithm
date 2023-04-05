package com.tzuxin.datastructures.tree.avl;

class Test{
    public static void main(String[] args) {
        // 需要右旋转
//        int[] arr = {7,8,5,6,4,3};
        //需要左旋转
//        int[] arr = {4,3,6,5,7,8};
        // 需要进行双旋转
        int[] arr = {10,11,7,6,8,9};
        AVLTree tree = new AVLTree();
        for (int value : arr) {
            // 如果左右子树的高度差值超过2，自动进行左右旋转
            // 如果出现需要双重旋转的情况，自动执行流程
            tree.add(new Node(value));
        }

        tree.midOrder();
        System.out.println("树的高度"+tree.getHeight());
        System.out.println("左子树的高度："+tree.leftHeight());
        System.out.println("右子树的高度："+tree.rightHeight());
    }
}

public class AVLTree {
    Node root;

    /**
     * 左旋转
      */
    public void leftRotate(){
        if (root != null){
            root = root.leftRotate();
        }
    }

    /**
     * 右旋转
      */
    public void rightRotate(){
        if (root!=null) {
            root = root.rightRotate();
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
            if (root.leftHeight() - root.rightHeight() > 1){
                // 此处需要判断是否会出现需要双旋转的情况，即旋转一次后依然不满足AVL的条件
                // 1、满足右旋转条件
                // 2、如果root的左子树的右子树大于左子树的高度
                // 3、先对root的左节点进行旋转
                // 4、再对root进行右旋转即可
                while (root.left.rightHeight() > root.left.leftHeight()){
                    root.left = root.left.leftRotate();
                }
                rightRotate();
            } else if (root.rightHeight() - root.leftHeight() > 1) {
                while (root.right.leftHeight() > root.right.rightHeight()){
                    root.right = root.right.rightRotate();
                }
                leftRotate();
            }
        }
    }

    /**
     * 查找value对应的Node
     * @param value Node的值
     * @return Node对象，找不到返回null
     */
    public Node searchNode(int value) {
        return root.searchNode(value);
    }

    /**
     * @return 左子树的高度
     */
    public int getHeight(){
        if (root != null){
            return root.getHigh();
        }
        return 0;
    }

    /**
     * @return 左子树的高度
     */
    public int leftHeight(){
        if (root != null){
            return root.leftHeight();
        }
        return 0;
    }
    /**
     * @return 右子树的高度
     */
    public int rightHeight(){
        if (root != null){
            return root.rightHeight();
        }
        return 0;
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
     * 中序遍历
     */
    public void midOrder(){
        if (root!=null) {
            root.midOrder();
        }
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

}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 左旋转
     * @return 新的root节点
     */
    public Node leftRotate(){
        // 1、建一个新节点，把原root设置为新节点的子节点
        // 值是root的右子树的值
        Node newNode = new Node(this.right.value);
        // 3、新节点的右子树=root的右子树的右子树
        newNode.right = this.right.right;
        //2、把原root的右子树设置为右子树的左子树
        this.right = this.right.left;
        // 4、新节点的左子树=root
        newNode.left = this;
        return newNode;
    }

    /**
     * 右旋转
     * @return 新的root节点
     */
    public Node rightRotate(){
        // 1、建一个新节点，把原root设置为新节点的子节点
        // 值是root的左子树的值
        Node newNode = new Node(this.left.value);
        // 3、新节点的左子树=root的左子树的左子树
        newNode.left = this.left.left;
        //2、把原root的左子树设置为左子树的右子树
        this.left = this.left.right;
        // 4、新节点的右子树=root
        newNode.right = this;
        return newNode;
    }

    /**
     * @return 左子树的高度
     */
    public int leftHeight(){
        if (left!=null){
            return left.getHigh();
        }
        return 0;
    }

    /**
     * @return 右子树的高度
     */
    public int rightHeight(){
        if (right!=null){
            return right.getHigh();
        }
        return 0;
    }

    /**
     * 返回以当前节点为根节点的树的高度
     * @return 高度
     */
    public int getHigh(){
        // 递归得到高度
        // 每次递归+1,取左/右树中最大的值，即高度
        return Math.max(left == null?0:left.getHigh(), right==null?0:right.getHigh()) + 1;
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

    /**
     * 根据value查找节点及其父节点
     * @param val 要查找的节点
     * @return [父节点，查找的节点]
     */
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

    /**
     * 中序排序
     */
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