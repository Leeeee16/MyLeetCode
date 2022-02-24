package com.algorithm.twoPointers;

import java.util.Arrays;

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums); // 排序
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return sum;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode16 lc = new LeetCode16();
        int[] nums = new int[]{1, 2, 5, 10, 11};
        int target = 12;
        int ans = lc.threeSumClosest(nums, target);
        System.out.println(ans);
    }
}
