package com.algorithm.jianzhi.jianzhi45;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/10/ 9:20
 */
public class Solution {
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] str = new String[len];
        for (int i = 0; i <len; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution jianzhi45 = new Solution();
        int[] nums = new int[]{4,2,1,12};
        String res = jianzhi45.minNumber(nums);
        System.out.println(res);
    }
}
