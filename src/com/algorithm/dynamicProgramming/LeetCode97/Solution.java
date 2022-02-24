package com.algorithm.dynamicProgramming.LeetCode97;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/14/ 20:09
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        // dp[i][j]表示s1的前i个和s2的前j个交叉可以组成s3的前i+j个
        // boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        boolean[] dp = new boolean[len2 + 1];
        dp[0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int p = i + j - 1;
                if (i > 0) {
                    // dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    // dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                    dp[j] = dp[j] || dp[j - 1] && s2.charAt(j - 1) == s3.charAt(p);
                }
            }
        }
        // return dp[len1][len2];
        return dp[len2];
    }
}
