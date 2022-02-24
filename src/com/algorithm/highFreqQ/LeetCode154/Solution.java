package com.algorithm.highFreqQ.LeetCode154;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/03/ 15:14
 */
public class Solution {
    public int findMin(int[] nums){
        int len = nums.length;
        if (len == 0) {
            System.out.println("数组不能为空");
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }else if (nums[mid] == nums[right]) {
                right--;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
