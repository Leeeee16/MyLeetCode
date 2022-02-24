package com.algorithm.jianzhi.jianzhi03;

import java.util.HashSet;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/04/ 10:21
 */
public class Solution2 {
    public int findRepeatNumber(int[] nums) {
        int tmp;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
