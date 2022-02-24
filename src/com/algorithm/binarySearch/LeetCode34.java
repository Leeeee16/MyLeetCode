package com.algorithm.binarySearch;

public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int[] res = {-1, -1};
        if (len < 1) {
            return res;
        }
        // 找右边界
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        // 不存在，直接返回res
        if (nums[left] != target) {
            return res;
        }
        // 找左端点
        res[1] = left;
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
        res[0] = left;
        return res;
    }

    public static void main(String[] args) {
        LeetCode34 lc = new LeetCode34();
        int[] nums = {};
        int target = 4;
        int[] res = lc.searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
