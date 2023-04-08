# DataStructuresAndAlgorithm
学习数据结构与算法的一些实例
# 1、数据结构
## 1) 栈
##### [计算器(Calculator.java)](./src/main/java/com/tzuxin/datastructures/stack/Calculator.java)
##### [中序表达式转后序表达式 (PolandNotation.java)](./src/main/java/com/tzuxin/datastructures/stack/PolandNotation.java)

## 2) 队列
##### [循环队列 (CircleArrayList.java)](./src/main/java/com/tzuxin/datastructures/queue/CircleArrayList.java)

## 3) 递归
##### [迷宫回溯问题(Maze.java)](./src/main/java/com/tzuxin/datastructures/recurrence/Maze.java)
##### [八皇后问题(Queen8.java)](./src/main/java/com/tzuxin/datastructures/recurrence/Queen8.java)

## 4) 哈希表(Hash Table)
[HashTableDemo.java](./src/main/java/com/tzuxin/datastructures/recurrence/HashTableDemo.java)

## 5) 树
##### [二叉树(Binary Tree)](./src/main/java/com/tzuxin/datastructures/tree/BinaryTreeDemo.java)
##### [顺序存储二叉树(Array Binary Tree)](./src/main/java/com/tzuxin/datastructures/tree/ArrayBinaryTreeDemo.java)
##### [线索二叉树(Threaded Binary Tree)](./src/main/java/com/tzuxin/datastructures/tree/threadedbinarytree/ThreadedBinaryTreeDemo.java)
##### [哈夫曼树(Huffman Tree)](./src/main/java/com/tzuxin/datastructures/tree/huffmantree/HuffmanTree.java)
##### [数据压缩(哈夫曼编码 Huffman Code)](./src/main/java/com/tzuxin/datastructures/tree/huffmancode/HuffmanCode.java)

实现文件压缩和解压操作

##### [二叉排序树(Binary Sort Tree)](./src/main/java/com/tzuxin/datastructures/tree/binarysorttree/BinarySortTree.java)

##### [平衡二叉树(AVL Tree)](./src/main/java/com/tzuxin/datastructures/tree/avl/AVLTree.java)



## 6) 图
##### [图(Graph)](./src/main/java/com/tzuxin/datastructures/graph/Graph.java)
实现广度优先和深度优先算法

实现左右旋转、双旋转

# 2、排序算法

## 1） 插入排序
##### [直接插入排序(Insertion Sort)](./src/main/java/com/tzuxin/datastructures/sort/InsertionSort.java)
时间复杂度：O(n^2)


稳定性：稳定


##### [希尔排序(Shell Sort)](./src/main/java/com/tzuxin/datastructures/sort/ShellSort.java)
时间复杂度：O(n^1.3)

稳定性：不稳定



## 2） 选择排序
#####  [简单选择排序(Select Sort)](./src/main/java/com/tzuxin/datastructures/sort/SelectSort.java)
时间复杂度：O(n^2)

稳定性：不稳定


##### [堆排序(Heap Sort)](./src/main/java/com/tzuxin/datastructures/sort/HeapSort)
时间复杂度：O(nlog2n) 

稳定性：不稳定




## 3）交换排序
##### [冒泡排序(Bubble Sorting)](./src/main/java/com/tzuxin/datastructures/sort/BubbleSort.java)
时间复杂度：O(n^2)

稳定性：稳定

##### [快速排序(Quick Sort)](./src/main/java/com/tzuxin/datastructures/sort/QuickSort.java)
时间复杂度：O(nlog2n)

稳定性：不稳定


## 4）归并排序
[归并排序(Merge Sort)](./src/main/java/com/tzuxin/datastructures/sort/MergeSort.java)

时间复杂度：O(nlog2n)

稳定性：稳定


## 5）基数排序
[基数排序(Radix Sort)](./src/main/java/com/tzuxin/datastructures/sort/RadixSort.java)

时间复杂度：O(n*k)

稳定性：稳定


# 3、查找算法
#####  [二分查找(Binary Search)](./src/main/java/com/tzuxin/datastructures/search/BinarySearch.java)

#####  [差值查找(Difference Search)](./src/main/java/com/tzuxin/datastructures/search/DifferenceSearch.java)

#####  [斐波那契(黄金分割法)查找(Fibonacci Search)](./src/main/java/com/tzuxin/datastructures/search/FibonacciSearch.java)


# 4、十大常见算法
### 4.1 [非递归二分查找(Binary Search)](src/main/java/com/tzuxin/algorithm/binarysearch/BinarySearch.java)



### 4.2 分治算法(Divide-and-Conquer)
#### **分支算法的基本步骤**

1. 分解：将原问题分解为若干个规模较小，相互独立，与原问题形式相同的子问题
2. 解决：若子问题规模较小而容易被解决则直接解，否则递归地解各个子问题
3. 合并：将各个子问题的解合并为原问题的解



#### 分治(Divide-and-Conquer(P))算法的设计模式

```
iflpl<n0
then return(ADHOC(P))
//将P分解为较小的子问题 P1,P2 ,...,Pkfori 1 to k
do yi< Divide-and-ConquerPi) 递归解决PiT MERGE(y1,y2,.,yk) 合并子问题
return(T)
```

其中IPI表示问题P的规模: n0为一闻值，表示当问题P的规模不超过n0时，问题已容易直接解出，不必再继续分解。ADHOC(P)是该分治法中的基本子算法，用于直接解小规模的问题P。因此，当P的规模不超过n0时直接用算法ADHOC(P)求解。算法MERGE(y1,y2,..,yk)是该分治法中的合并子算法，用于将P的子问题P1,P2 ,...,Pk的相应的解y1,y2,...,yk合并为P的解。



#### 分治算法最佳实践-汉诺塔

汉诺塔的传说汉诺塔: 汉诺塔(又称河内塔) 问题是源于印度一个古老传说的益智玩具。大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。并且规定在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。



#### 实现思路：

- 如果只有一个盘，A -> C

- 如果n(n >= 2)个盘，可以看作是2个盘：**最下边的盘**和**上面的盘**

  1）先把最上面的盘A->B

  2）把最下边的盘A->C

  3）把B的所有盘从B-C（代入第1步）

