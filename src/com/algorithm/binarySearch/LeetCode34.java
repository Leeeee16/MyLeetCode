package com.algorithm.binarySearch;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int[] ans = {-1, -1};
        // 找右边界
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        // 不存在，则返回-1 -1
        if (nums[left] != target) {
            return ans;
        } else {    // 找左边界
            ans[1] = left;
            left = 0;
            right = len - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ans[0] = left;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode34 lc = new LeetCode34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 4;
        int[] res = lc.searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
