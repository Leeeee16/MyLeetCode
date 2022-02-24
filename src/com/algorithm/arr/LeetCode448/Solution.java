package com.algorithm.arr.LeetCode448;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }
        for (int i = 0; i < len; i++) {
            nums[(nums[i] - 1) % len] += len;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] < len) {
                ans.add(i);
            }
        }
        return ans;
    }
}
