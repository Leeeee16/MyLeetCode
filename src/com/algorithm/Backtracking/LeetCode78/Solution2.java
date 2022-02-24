package com.algorithm.Backtracking.LeetCode78;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/16/ 8:35
 */
public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        int size = 1 << len;
        for (int i = 0; i < size; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) == 0) {
                    continue;
                }
                subset.add(nums[j]);
            }
            res.add(subset);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution2 s78 = new Solution2();
        List<List<Integer>> res = new ArrayList<>();
        res = s78.subsets(nums);
        System.out.println(res.toString());
    }
}
