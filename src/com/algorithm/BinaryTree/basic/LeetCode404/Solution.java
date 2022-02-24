package com.algorithm.BinaryTree.basic.LeetCode404;

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 判断左孩子是否为叶节点
        if(root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val +sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
