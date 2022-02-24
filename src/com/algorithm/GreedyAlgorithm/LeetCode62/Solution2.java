package com.algorithm.GreedyAlgorithm.LeetCode62;

import java.util.Arrays;

public class Solution2 {
    public int uniquePaths(int m, int n) {
        // dp 空间优化
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}
