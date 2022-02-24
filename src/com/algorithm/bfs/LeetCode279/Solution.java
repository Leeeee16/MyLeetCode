package com.algorithm.bfs.LeetCode279;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * 动态规划解
 */
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 基础情况
        dp[0] = 0;

        // 计算完全平方数
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; i++) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s < max_square_index; s++) {
                if (i < square_nums[s]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        System.out.println(Arrays.toString(square_nums));
        System.out.println(Arrays.toString(dp));

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.numSquares(20);
        System.out.println(ans);
    }
}
