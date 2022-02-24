package com.algorithm.SlidingWindow.LeetCode209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;
        while (right < len) {
            // right向右移动
            while (right < len && sum < target) {
                sum += nums[right];
                right++;
            }
            if (sum < target) {
                break;
            }
            // left向右移动
            while (left < right && sum >= target) {
                sum -= nums[left];
                left++;
            }
            ans = ans == 0 || right - left + 1 < ans ? right - left + 1 : ans;
        }
        return ans;
    }
}
