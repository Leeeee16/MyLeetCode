package com.algorithm.BinaryTree.basic.LeetCode111;

public class Solution {
    /**
     * 最小深度：根节点到最近的叶节点(没有孩子)的节点数量
     * 如果是叶子节点：返回 1
     * 如果只有一个孩子：返回那个孩子的深度
     * 如果有两个孩子：返回两个孩子深度中较小的那个
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(root.left == null || root.right == null) {
            return left + right + 1;
        }

        return Math.min(left, right) + 1;
    }
}
