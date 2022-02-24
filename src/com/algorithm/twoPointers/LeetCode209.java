package com.algorithm.twoPointers;

public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int len = 0;
        int i = 0;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum > s) {
                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LeetCode209 lc = new LeetCode209();
        int[] nums = new int[]{2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 1, 2, 3};
        int s = 13;
        int res = lc.minSubArrayLen(s, nums);
        System.out.println(res);
    }
}
