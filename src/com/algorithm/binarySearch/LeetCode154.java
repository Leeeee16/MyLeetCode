package com.algorithm.binarySearch;

public class LeetCode154 {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                right--;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        LeetCode154 lc = new LeetCode154();
        int[] nums = {2, 2, 2, 0, 1};
        int min = lc.findMin(nums);
        System.out.println(min);
    }
}
