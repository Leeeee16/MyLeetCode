package com.algorithm.dynamicProgramming.LeetCode332;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/23/ 9:54
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 将所有的值设置为 amount + 1，表示可能凑出
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // dp[i] = min{dp[i - 1], dp[i - 2], dp[i - 5]};
            for (int coin : coins) {
                // 注意后半部分的判断，dp[i - coin]需要能凑出才行
                if (i - coin >= 0 && dp[i - coin] != amount + 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
