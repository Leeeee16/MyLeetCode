package com.algorithm.BinaryTree.basic.LeetCode145;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归解
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        help(root, list);
        return list;
    }

    private void help(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        help(root.left, list);
        help(root.right, list);
        list.add(root.val);
    }
}
