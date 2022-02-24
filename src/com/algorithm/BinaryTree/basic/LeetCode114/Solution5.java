package com.algorithm.BinaryTree.basic.LeetCode114;

/**
 * @Description:
 * @author: lqy
 * @date: 2021/03/29/ 21:36
 */
public class Solution5 {

    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
