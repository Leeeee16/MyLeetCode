package com.algorithm.dynamicProgramming.LeetCode5;

import java.util.Arrays;

/**
 * @author: lqy
 * @create: 2021/3/8
 * @description: 动态规划解，时空复杂度：O(N^2)
  */
public class Solution2 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int begin = 0;

        // dp数组从对角线开始，向右上进行计算
        // 因为dp[i][j]的值取决于左下角的dp[i + 1][j - 1]
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    // 长度小于等于3 且 c[i] == c[j]肯定为回文串
                    if (j - i + 1 < 4) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

}
