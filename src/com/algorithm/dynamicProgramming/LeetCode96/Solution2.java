package com.algorithm.dynamicProgramming.LeetCode96;

public class Solution2 {
    // 卡塔兰数
    // 递推式：h(n)=h(n-1)*(4*n-2)/(n+1)
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int)C;
    }
}
