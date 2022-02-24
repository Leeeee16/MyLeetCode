package com.algorithm.GreedyAlgorithm.LeetCode55;

public class Solution2 {
    // 从后向前
    public boolean canJump (int[] nums) {
        int len = nums.length;
        int lastPos = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
