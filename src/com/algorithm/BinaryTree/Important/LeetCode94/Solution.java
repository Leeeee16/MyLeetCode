package com.algorithm.BinaryTree.Important.LeetCode94;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归解
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
