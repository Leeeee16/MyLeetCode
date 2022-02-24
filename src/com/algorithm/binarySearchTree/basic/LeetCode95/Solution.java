package com.algorithm.binarySearchTree.basic.LeetCode95;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/03/28/ 16:01
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        // dp[i]表示长度为i的所有情况子树的根节点
        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList();
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);

        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList();
            for (int root = 1; root <= i; root++) {
                // 左子树的节点数
                int left = root - 1;
                // 右子树的节点数
                int right = i - root;

                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode newTree = new TreeNode(root);
                        // 左子树直接连
                        newTree.left = leftTree;
                        // 右子树的节点的值需要加上根节点的值
                        newTree.right = clone(root, rightTree);
                        dp[i].add(newTree);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode clone(int val, TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(val + root.val);
        newNode.left = clone(val, root.left);
        newNode.right = clone(val, root.right);
        return newNode;
    }
}
