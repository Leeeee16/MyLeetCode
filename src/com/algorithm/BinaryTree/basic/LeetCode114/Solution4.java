package com.algorithm.BinaryTree.basic.LeetCode114;


/**
 * @Description: 比较好理解的做法
 * @author: lqy
 * @date: 2021/03/29/ 21:32
 */
public class Solution4 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode node = root.left;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
