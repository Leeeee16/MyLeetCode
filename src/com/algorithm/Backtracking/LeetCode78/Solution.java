package com.algorithm.Backtracking.LeetCode78;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/16/ 8:24
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int begin, Deque<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < len; i++) {
            path.addLast(nums[i]);
            dfs(nums, len, i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
         int[] nums = new int[]{1,2,3};
         Solution s78 = new Solution();
         List<List<Integer>> ans = new ArrayList<>();
         ans = s78.subsets(nums);
        System.out.println(ans.toString());
    }
}
