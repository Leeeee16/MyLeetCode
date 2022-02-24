package com.algorithm.SlidingWindow.LeetCode1208;

public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] diff = new int[len];
        for (int i = 0; i < len; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int left = 0;
        int right = 0;
        int curCost = 0;
        int ans = 0;
        while (right < len) {
            curCost += diff[right];
            while (curCost > maxCost) {
                curCost -= diff[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
