package com.algorithm.binarySearchTree.basic.LeetCode96;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/03/28/ 16:31
 */
public class Solution {
    public int numTrees(int n) {
        // dp表示长度为i的子树有几种情况
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int root = 1; root <= i; root++) {
                int left = root - 1;
                int right = i - root;
                dp[i] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}
