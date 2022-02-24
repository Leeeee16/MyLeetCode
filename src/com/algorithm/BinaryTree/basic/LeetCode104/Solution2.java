package com.algorithm.BinaryTree.basic.LeetCode104;

public class Solution2 {
    /**
     * 后序遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
