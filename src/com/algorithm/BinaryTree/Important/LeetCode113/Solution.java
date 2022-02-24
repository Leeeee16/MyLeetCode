package com.algorithm.BinaryTree.Important.LeetCode113;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/03/29/ 20:51
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<Integer> path = new LinkedList<>();
        dfs(root, res, path, targetSum);
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, Deque<Integer> path, int targetSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            path.addLast(root.val);
            res.add(new ArrayList(path));
            path.removeLast();
            return;
        }
        path.add(root.val);
        dfs(root.left, res, path, targetSum - root.val);
        dfs(root.right, res, path, targetSum - root.val);
        // 回溯
        path.removeLast();
    }
}
