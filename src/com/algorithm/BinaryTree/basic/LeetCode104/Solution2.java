package com.algorithm.BinaryTree.basic.LeetCode104;

public class Solution2 {
    /**
     * εεΊιε
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
