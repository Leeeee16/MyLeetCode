package com.algorithm.BinaryTree.Important.LeetCode226;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    // 层次遍历
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null || node.right != null) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}
