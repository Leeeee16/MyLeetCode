package com.algorithm.BinaryTree.advance.LeetCode222;

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root, true);
        int rightDepth = depth(root, false);
        if (leftDepth == rightDepth) {
            // 是完全二叉树
            return (1 << leftDepth) - 1;
        } else {
            // 1是根节点
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    /**
     * 计算深度
     * @param node
     * @param isLeft：是否是左子树
     * @return
     */
    private int depth(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        int depth = 0;
        while (node != null) {
            depth++;
            node = isLeft ? node.left : node.right;
        }
        return depth;
    }
}
