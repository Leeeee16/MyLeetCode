package com.algorithm.BinaryTree.basic.LeetCode257;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, new StringBuilder(), res);
        return res;
    }

    private void dfs(TreeNode node, StringBuilder sb, List<String> res) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        // 如果是叶节点，返回
        if (node.left == null && node.right == null) {
            res.add(sb.toString());
            return;
        }
        sb.append("->");
        dfs(node.left, new StringBuilder(sb), res);
        dfs(node.right, new StringBuilder(sb), res);
    }
}
