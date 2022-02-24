package com.algorithm.GreedyAlgorithm.LeetCode45;

public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int maxIdx = 0;
        int end = 0;
        int ans = 0;
        // 因为开始时边界为0，ans已经+1，因此遍历到 len - 1即可
        for (int i = 0; i < len - 1; i++) {
            maxIdx = Math.max(maxIdx, nums[i] + i);
            if (i == end) {
                // 遇到边界，更新边界，步数+1
                end = maxIdx;
                ans++;
            }
        }
        return ans;
    }
}
