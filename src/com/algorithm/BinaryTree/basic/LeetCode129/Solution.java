package com.algorithm.BinaryTree.basic.LeetCode129;

public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return dfs(root,0);

    }

    private int dfs(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        int curSum = sum * 10 + root.val;
        if( root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left,curSum) + dfs(root.right, curSum);
    }
}
