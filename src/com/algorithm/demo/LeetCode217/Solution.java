package com.algorithm.demo.LeetCode217;

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        HashSet<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num)) {
                return true;
            } else {
                visited.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4,4};
        Solution s = new Solution();
        boolean res =  s.containsDuplicate(nums);
        System.out.println(res);
    }
}
