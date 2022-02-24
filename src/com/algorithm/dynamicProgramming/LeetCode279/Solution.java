package com.algorithm.dynamicProgramming.LeetCode279;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/23/ 10:01
 */
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int k = 1;
            while (i - k * k >= 0 && dp[i - k * k] != n + 1) {
                dp[i] = Math.min(dp[i], dp[i - k * k] + 1);
                k++;
            }
        }
        return dp[n] == n + 1 ? -1 : dp[n];
    }
}
