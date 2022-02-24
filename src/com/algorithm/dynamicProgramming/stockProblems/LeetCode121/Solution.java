package com.algorithm.dynamicProgramming.stockProblems.LeetCode121;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int dp = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] > min) {
                dp = Math.max(dp, prices[i] - min);
            }
            min = Math.min(prices[i], min);
        }
        return dp;
    }
}
