package com.algorithm.dynamicProgramming.ZeroOneKnapsack;

/**
 * @author: lqy
 * @create: 2020/12/13
 * @description: 0-1背包 动态规划解
 */
public class Solution {

    /**
     * 0-1背包动态规划解
     * 子问题：将前i个物品放入容量为j的背包中：dp[i][j]
     * case1：如果不放第i个物品 --转化为--> 前 i - 1 个物品放入容量为 j 的背包中：dp[i - 1][j]
     * case2：如果放第i个物品 --转化为--> 前 i - 1 个物品放入容量为 j - w[i] 的背包中：dp[i - 1][j - w[i]] + v[i]
     * 时间和空间复杂度：均为 O(N·V)
     *
     * @param N：物品数
     * @param V：背包容量
     * @param weight：物品的重量数组
     * @param value：物品的价值数组
     * @return 背包能装的最大价值
     */
    public int maxValue(int N, int V, int[] weight, int[] value) {
        // dp[i][j]：背包容量为j时，前i个物品所能达到的最大价值
        // 注意：这里i表示第i个物品，对应weight数组和value数组时下标应-1
        int[][] dp = new int[N + 1][V + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                // 放入第i个物品
                if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                } else {
                    // 不放入第i个物品
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][V];
    }


    /**
     * 空间复杂度优化为 O(V)
     * 思路：dp[i][j]是由 dp[i - 1][j] 和 dp[i - 1][j - w[i - 1]] 两个子问题递推得到
     * 因此，可以在每次循环 i 时，j从 V ~ 0 遍历，得到 dp[j]
     */
    public int maxValue2(int N, int V, int[] weight, int[] value) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= weight[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
            }
        }
        return dp[V];
    }
}
