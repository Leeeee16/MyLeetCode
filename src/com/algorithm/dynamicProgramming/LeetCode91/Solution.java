package com.algorithm.dynamicProgramming.LeetCode91;

public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        // dp[i]：以s[i]为结尾的前缀子串有多少种解码方法
        // dp[i] = dp[i - 1] * 1   if s[i] != '0'
        // dp[i] = dp[i - 2] * 1   if 10 <= int(s[i - 1...i] <= 26)
        int[] dp = new int[len];
        char[] charArray = s.toCharArray();
        // 第一个为0直接返回0
        if (charArray[0] == '0') {
            return 0;
        }
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0') {
                dp[i] = dp[i - 1];
            }

            // 检查前两个数字是否在10~26之间
            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }
}
