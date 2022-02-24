package com.algorithm.SlidingWindow.LeetCode567;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] pattern = s1.toCharArray();
        char[] text = s2.toCharArray();

        int pLen = s1.length();
        int tLen = s2.length();

        int[] pFreq = new int[26];
        int[] winFreq = new int[26];

        for (int i = 0; i < pLen; i++) {
            pFreq[pattern[i] - 'a']++;
        }

        int pCount = 0;
        for (int i = 0; i < 26; i++) {
            if (pFreq[i] > 0) {
                pCount++;
            }
        }

        int left = 0;
        int right = 0;
        // 滑动窗口中的某个字符个数与 s1 中对应相等的时候才计数
        int winCount = 0;
        while (right < tLen) {
            // 右边界向右
            // 当前字符是s1中的字符
            if (pFreq[text[right] - 'a'] > 0) {
                winFreq[text[right] - 'a']++;
                // 当前字符的频数 与 s1 中频数相等，计数+1
                if (winFreq[text[right] - 'a'] == pFreq[text[right] - 'a']) {
                    winCount++;
                }
            }
            right++;
            // 左边界向左
            while (pCount == winCount) {
                // 如果滑动窗口的大小 = pLen，则找到，返回true
                if (right - left == pLen) {
                    return true;
                }
                // 如果当前字符 s1 中存在
                if (pFreq[text[left] - 'a'] > 0) {
                    winFreq[text[left] - 'a']--;
                    if (winFreq[text[left] - 'a'] < pFreq[text[left] - 'a']) {
                        winCount--;
                    }
                }
                left++;
            }
        }
        return false;
    }
}
