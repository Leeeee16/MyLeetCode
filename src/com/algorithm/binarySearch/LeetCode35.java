package com.algorithm.binarySearch;

/**
 * @author: lqy
 * @create: 2020/11/1
 * @description: LeetCode35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 *
 * 你可以假设数组中无重复元素。
 */
public class LeetCode35 {
    public static void main(String[] args) {
        LeetCode35 lc = new LeetCode35();
        int[] nums = {1, 3, 5, 6};
        int target = 8;
        int res = lc.searchInsert(nums, target);
        System.out.println(res);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if(target > nums[right]) {
            return right + 1;
        }
        while (left < right) {
            int mid = left + right >> 1;
            // 小于target一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索区间 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间 [left, mid]
                right = mid;
            }
        }
        return left;
    }
}
