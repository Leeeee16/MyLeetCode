package com.algorithm.Backtracking.LeetCode40;

import java.util.*;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/12/ 9:21
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, len, target, res, path);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, List<List<Integer>> res, Deque<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                return;
            } else {
                path.addLast(candidates[i]);
                dfs(candidates, i + 1, len, target - candidates[i], res, path);
                path.removeLast();
            }
            while (i < len - 1 && candidates[i] == candidates[i + 1]) i++;
        }
    }
}
