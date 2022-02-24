package com.algorithm.jianzhi.jianzhi03;

import java.util.HashSet;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/04/ 10:19
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
