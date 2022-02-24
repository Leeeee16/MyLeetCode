package com.algorithm.SlidingWindow.LeetCode3;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        // 用数组记录滑动窗口中出现的字符
        int[] hashMap = new int[128];

        char[] charArray = s.toCharArray();
        int res = 1;
        for (int left = 0, right = 0; right < len; right++) {
            hashMap[charArray[right]]++;
            if (hashMap[charArray[right]] == 2) {
                // left 向右移动
                hashMap[charArray[left]]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
