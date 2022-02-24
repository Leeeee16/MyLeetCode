package com.algorithm.binarySearch;

public class LeetCode153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > nums[left]) { // 左区间有序
                min = Math.min(min, nums[left]);
                left = mid;
            } else {
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        LeetCode153 lc = new LeetCode153();
        int[] nums = {4,1,2};
        int min = lc.findMin(nums);
        System.out.println(min);
    }
}
