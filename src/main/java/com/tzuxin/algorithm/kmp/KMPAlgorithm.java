package com.tzuxin.algorithm.kmp;

import java.util.Arrays;
import java.util.Objects;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println(kmpAlgorithm(str1, str2));
    }

    public static int[] kmpNext;

    /**
     * 返回目标的下标位置，找不到返回-1
     *
     * @param source 要查找的文本字符串
     * @param target 查找的目标
     * @return 下标位置，找不到为-1
     */
    public static int kmpAlgorithm(String source, String target) {
        getKmpNext(target);
        for (int i = 0, j = 0; i < source.length(); i++) {
            // 当匹配不上时，在列表里找j的大小，即需要跳过多少个字符
            while (j > 0 && source.charAt(i) != target.charAt(j)) {
                j = kmpNext[j - 1];
            }
            if (source.charAt(i) == target.charAt(j)) {
                j++;
            }
            if (j == target.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 根绝字符串求部分匹配表
     *
     * @param dest 字符串
     * @return 部分匹配表
     */
    private static void getKmpNext(String dest) {
        kmpNext = new int[dest.length()];
        kmpNext[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            // 当dest.charAt(i) != dest.charAt(j) 需要从next[j-1]获取新的j
            while (j > 0 && dest.charAt(i) != dest.charAt(j)){
                j = kmpNext[j-1];
            }
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            kmpNext[i] = j;
        }
    }
}
