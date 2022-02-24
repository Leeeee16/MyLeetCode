package com.algorithm.dynamicProgramming.LeetCode5;

/**
 * @author: lqy
 * @create: 2021/3/8
 * @description: 中心扩散法，时：O(N^2),空：O(1)
  */
public class Solution3 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < len - 1; i++) {
            String odd = centerSpread(s, i, i);
            String even = centerSpread(s, i, i + 1);
            String cur = odd.length() > even.length() ? odd: even;
            if (cur.length() > maxLen) {
                maxLen = cur.length();
                res = cur;
            }
        }
        return res;
    }

    private String centerSpread(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            } else {
                left--;
                right++;
            }
        }
        // 注意此时s[left] != s[right]
        return s.substring(left + 1, right);
    }
}
