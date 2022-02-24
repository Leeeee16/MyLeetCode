package com.algorithm.binarySearch.LeetCode81;

/**
 * @author: lqy
 * @create: 2020/11/2
 * @description: LeetCode81
  */
public class Solution1 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int left = 0, right = len - 1;
        while (left < right) {
            // 采用向上取整，[left, mid - 1], [mid, right]
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[right]) {  // 右区间有序（严格小于）
                // target在有序区间内
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                // 右半部分一定无序，做边可能有序，可能重复
                // 因此判断条件不能写成nums[mid] > nums[right]
                // 为了保持收缩一致，我们认为[left, mid - 1]是有序的（同33题）
                // 如果target在[left, mid - 1]区间内
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            } else {
                // nums[mid] == nums[right]
                // 表示nums[right] != target，将right位置排除
                right--;
            }
        }
        return nums[left] == target;
    }

    public static void main(String[] args) {
        Solution1 lc = new Solution1();
        int[] nums = {3,1,1,1};
        int target = 3;
        boolean res = lc.search(nums, target);
        System.out.println(res);
    }
}
