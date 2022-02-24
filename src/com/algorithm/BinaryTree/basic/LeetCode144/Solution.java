package com.algorithm.BinaryTree.basic.LeetCode144;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归解
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
