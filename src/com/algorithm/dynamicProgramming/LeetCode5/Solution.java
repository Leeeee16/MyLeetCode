package com.algorithm.dynamicProgramming.LeetCode5;

/**
 * @author: lqy
 * @create: 2021/3/8
 * @description: 暴力解：O(N ^ 3)
  */
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();
        // 最长回文子串的长度
        int maxLen = 1;
        // 最长回文子串的起始坐标
        int begin = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindrome(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证回文串
     * @param charArray
     * @param left
     * @param right
     * @return
     */
    private boolean validPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
