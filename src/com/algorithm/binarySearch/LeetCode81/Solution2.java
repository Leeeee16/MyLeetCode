package com.algorithm.binarySearch.LeetCode81;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/08/ 10:43
 */
public class Solution2 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        // 特判
        if (len == 0) {
            return false;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else if (nums[mid] > nums[right]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }
        }
        return nums[left] == target;
    }
}
