package com.algorithm.dynamicProgramming.LeetCode746;

public class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int pre1 = cost[0];
        int pre2 = cost[1];
        int dpi = -1;
        for (int i = 2; i < len; i++) {
            dpi = Math.min(pre1, pre2) + cost[i];
            pre1 = pre2;
            pre2 = dpi;
        }
        return Math.min(pre1, pre2);
    }
}
