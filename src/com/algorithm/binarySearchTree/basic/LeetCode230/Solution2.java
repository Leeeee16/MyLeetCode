package com.algorithm.binarySearchTree.basic.LeetCode230;

public class Solution2 {
    private int count = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        count--;
        if (count == 0) {
            this.res = node.val;
            return;
        }
        dfs(node.right);
    }
}
