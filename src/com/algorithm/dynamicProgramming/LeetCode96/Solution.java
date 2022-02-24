package com.algorithm.dynamicProgramming.LeetCode96;

public class Solution {
    public int numTrees(int n) {
        // G[i]：长度为n的序列能构成的不同二叉搜索树的个数
        int[] G = new int[n + 1];
        // 初始化
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
