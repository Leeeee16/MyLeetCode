package com.algorithm.GreedyAlgorithm.LeetCode55;

public class Solution {
    // 从前往后
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxIdx = 0;
        for (int i = 0; i < len; i++) {
            if (i > maxIdx) {
                return false;
            }
            maxIdx = Math.max(maxIdx, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        Solution solution = new Solution();
        boolean ans = solution.canJump(nums);
        System.out.println(ans);
    }
}
