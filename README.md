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
### 4.1 非递归二分查找(Binary Search)

##### [代码实现](src/main/java/com/tzuxin/algorithm/binarysearch/BinarySearch.java)

```java
/**
 * 二分查找非递归的方法
 * @param arr 要查找的数组，要求升序排序
 * @param target 查找的目标
 * @return 目标在数组中的下标
 */
public static int binarySearch(int[] arr, int target){
    int left = 0;
    int right = arr.length - 1;
    int mid;
    while (left<=right){
        mid = (right + left) / 2;
        if (arr[mid] == target){
            return mid;
        } else if (target < arr[mid]) {
            right = mid-1;
        }else if (target > arr[mid]){
            left = mid+1;
        }
    }
    return -1;
}
```



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



#### 实现思路

- 如果只有一个盘，A -> C

- 如果n(n >= 2)个盘，可以看作是2个盘：**最下边的盘**和**上面的盘**

  1）先把最上面的盘A->B

  2）把最下边的盘A->C

  3）把B的所有盘从B-C（代入第1步）



##### [代码实现](src/main/java/com/tzuxin/algorithm/divideandconquer/HanoiTower.java)

```java
/**
 * 
 * @param num 有多少个盘
 * @param a 从哪里移动
 * @param b 其他柱子
 * @param c 移动到哪里
 */
public static void hanoiTower(int num, char a, char b, char c){
    if (num <= 1){
        System.out.println("从" + a + " -> " + c);
    }else {
        // 把最上面的盘都移动到缓冲盘(a上面的盘都移动到b，然后才能放到c上)
        hanoiTower(num - 1, a, c, b);
        // 2、最底下的盘可以移动了
        System.out.println("从" + a + " -> " + c);
        // 3、继续把没移动完的盘进行移动(b移动到c，用a做缓冲)
        hanoiTower(num - 1, b, a, c);
    }
}
```



### 4.3 动态规划算法

#### 应用场景：背包问题

有一个背包，容量为4磅，现有如下物品

|  物品   | 重量 | 价格 |
| :-----: | :--: | :--: |
| 吉他(G) |  1   | 1500 |
| 音响(S) |  4   | 3000 |
| 电脑(L) |  3   | 2000 |

- 要求达到的目标为装入的背包的总价值最大，并且重量不超出
- 要求装入的物品不能重复（01背包问题）

#### 动态规划算法介绍

1. 动态规划(Dynamic Programming)算法的核心思想是: 将大问题划分为小问题进行解决，从而一步步获取最优解的处理算法。
2. 动态规划算法与分治算法类似，其基本思想也是将待求解问题分解成若干个子问题，先求解子问题，然后从这些子问题的解得到原问题的解。
3. 与分治法不同的是，适合于用动态规划求解的问题，经分解得到子问题往往不是互相独立的。(即下一个子阶段的求解是建立在上一个子阶段的解的基础上，进行进一步的求解 )
4. 动态规划可以通过填表的方式来逐步推进，得到最优解。

#### 思路分析

- 背包问题主要是指一个给定容量的背包、若干具有一定价值和重量的物品，如何选择物品放入背包使物品的价值最大。其中又分01背包和完全背包(完全背包指的是:每种物品都有无限件可用)
- 这里的问题属于01背包，即每个物品最多放一个。而无限背包可以转化为01背包

算法的主要思想，利用动态规划来解决。每次遍历到的第i个物品，根据wi和vli来确定是否需要将该物品放入背包中。即对于给定的n个物品，设vi、w\[i]分别为第i个物品的价值和重量，C为背包的容量。再令v\[i]\[j]表示在前i个物品中能够装入容量为j的背包中的最大价值。则我们有下面的结果:

| 物品    | 0磅  | 1磅     | 2磅     | 3磅     | 4磅             |
| ------- | ---- | ------- | ------- | ------- | --------------- |
|         | 0    | 0       | 0       | 0       | 0               |
| 吉他(G) | 0    | 1500(G) | 1500(G) | 1500(G) | 1500(G)         |
| 音响(S) | 0    | 1500(G) | 1500(G) | 1500(G) | 3000(G)         |
| 电脑(L) | 0    | 1500(G) | 1500(G) | 2000(G) | 2000(G)+1500(G) |
|         |      |         |         |         |                 |


$$
v[i][0]=v[0][j]=0;
$$

> （表示第一列、行是0）


$$
当w[i]>j: v[i][j]=v[i-1][j]
$$

> （如果装不下，就使用上一次的重量）


$$
当j>=w[i]: v[i][j]=max(v[i-1][j],value[i]+v[i-1][j-w[j]])
$$

> 当准备装入的商品重量小于等于当前背包容量时（装得下或者装下后还有剩余空间），在以下选项中选出最大
>
> 1）**v\[i-1]\[j]** （上一个单元格的装入的最大值）
>
> 2）**value\[i]** （表示当前商品的价值） +  **v\[i-1]\[j-w\[j]]**：（除掉当前商品的重量，还能装下的最大价值）



##### [代码实现](src/main/java/com/tzuxin/algorithm/dynamic/KnapsackProblem.java)

```java
// 开始动态算法
// 从1开始，因为第一列都是0
for (int i = 1; i < v.length; i++) {
    for (int j = 1; j < v[i].length; j++) {
        // 判断是否能装下当前的good
        if (goods[i].weight > w[j]) {
            // 装不下就用上一次的值
            v[i][j] = v[i-1][j];
        }else {
            // 当准备装入的商品重量小于等于当前背包容量时（装得下或者装下后还有剩余空间），在以下选项中选出最大
            //1）v[i-1][j] （上一个单元格的装入的最大值）
            //2）goods[i].value （表示当前商品的价值） +  v[i-1][j-goods[i].weight]：（除掉当前商品的重量，还能装下的最大价值）
            v[i][j] = Math.max(v[i-1][j], goods[i].value + v[i-1][j-goods[i].weight]);
        }
    }
}
```



### 4.4 KMP算法

#### KMP算法介绍

1. KMP是一个解决模式串在文本串是否出现过，如果出现过，最早出现的位置的经典算法
2. Knuth-Morris-Pratt**字符串查找算法**，简称为“KMP算法”，常用于在一个文本串s内查找一个模式串P 的出现位置，这个算法由DonaldKnuth、Vaughan Pratt.James H.Morris三人于1977年联合发表，故取这3人的姓氏命名此算法
3. KMP方法算法就利用之前判断过信息，通过一个next数组，保存模式串中前后3最长公共子序列的长度，每次回溯时，通过next数组找到，前面匹配过的位置省去了大量的计算时间
4. 参考资料: https://www.cnblogs.com/ZuoAndFutureGirl/p/9028287.html



#### 应用：字符串匹配问题

1) 有一个字符串 str1="BBCABCDAB ABCDABCDABDE”，和一个子串str2="ABCDABD"；
2) 现在要**判断 str1是否含有 str2**，如果存在，就返回第一次出现的位置，如果没有则返回-1；
3) 要求：使用KMP算法完成判断，不能使用简单的暴力匹配算法。



#### 部分匹配表

| 搜索词     | A    | B    | C    | D    | A    | B    | D    |
| ---------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 部分匹配值 | 0    | 0    | 0    | 0    | 1    | 2    | 0    |



##### 什么是前缀后缀

字符串：“ABCD”

前缀：A, AB, ABC

后缀：B, BC, BCD

##### 部分匹配值计算

“部分匹配值”就是”前缀”和”后缀”的最长的共有元素的长度。以”ABCDABD”为例

”A”的前缀和后缀都为空集，共有元素的长度为 **0**;

”AB”的前缀为[A]，后缀为[B]，共有元素的长度为 **0**;

ABC”的前缀为[A,AB]，后缀为[BC,C]，共有元素的长度 **0**;

ABCD”的前缀为[A,AB,ABC]，后缀为[BCD,CD,D]，共有元素的长度为 **0**;

ABCDA”的前缀为[**A**,AB,ABC,ABCD]，后缀为BCDA,CDA,DA,**A**]，共有元素为”A”，长度为**1**;

ABCDAB”的前缀为[A,**AB**,ABC,ABCD,ABCDA]，后缀为[BCDAB,CDAB,DAB,**AB**,B]共有元素为”AB”长度为 **2**;

”ABCDABD”的前缀为[A,AB,ABC,ABCD,ABCDA,ABCDAB]，后缀为[BCDABD,CDABD,DABD,ABD,BD,D]，共有元素的长度为 **0**

> ”部分匹配”的实质是，有时候，字符串头部和尾部会有重复。比如，”ABCDAB”之中有两个”AB”，那么它的”部分匹配值”就是2(”AB”的长度)。搜索词移动的时候，第一个”AB”向后移动 4 位(字符串长度部分匹配值)，就可以来到第二个”AB”的位置。



### 4.5 贪心算法



#### 贪心算法介绍

1. 贪婪算法(贪心算法)是指在对问题进行求解时，**在每一步选择中都采取最好或者最优(即最有利)的选择**，从而希望能够导致结果是最好或者最优的算法
2. 贪婪算法所得到的结果不一定是最优的结果(有时候会是最优解)，但是都是相对近似(接近)最优解的结果



#### 应用场景-集合覆盖问题

##### 问题

假设存在下面需要付费的广播台，以及广播台信号可以覆盖的地区。如何选择最少的广播台，让所有的地区都可以接收到信号

| 广播台 | 覆盖地区               |
| ------ | ---------------------- |
| K1     | "北京", "上海", "天津" |
| K2     | "广州", "北京", "深圳" |
| K3     | "成都", "上海", "杭州" |
| K4     | "上海", "天津"         |
| K5     | "杭州", "大连"         |



##### 思路分析

使用贪婪算法，效率高:

目前并没有算法可以快速计算得到准备的值，使用贪婪算法，则可以得到非常接近的解，并且效率高。选择策略上，因为需要覆盖全部地区的最小集合

1. 遍历所有的广播电台，找到一个覆盖了最多未覆盖的地区的电台(此电台可能包含一些已覆盖的地区，但没有关系)
2. 将这个电台加入到一个集合中(比如 ArrayList)，想办法把该电台覆盖的地区在下次比较时去掉。
3.  重复第 1 步**直到覆盖了全部的地区**。



##### 注意事项和细节

1. 贪婪算法所得到的结果不一定是最优的结果(有时候会是最优解)，但是都是相对近似(接近)最优解的结果；
2. 比如上题的算法选出的是 K1、K2、K3、K5，符合覆盖了全部的地区；
3. 但是我们发现 K2、K3、K4、K5 也可以覆盖全部地区，如果K2 的使用成本低于 K1,那么我们上题的 K1、K2、K3、K5 虽然是满足条件，但是并不是最优的。



