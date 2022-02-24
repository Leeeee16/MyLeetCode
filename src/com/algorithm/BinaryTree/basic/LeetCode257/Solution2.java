package com.algorithm.BinaryTree.basic.LeetCode257;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode node, String path, List<String> res) {
        // 走到叶节点，将路径加入结果列表
        if (node.left == null && node.right == null) {
            res.add(path + node.val);
            return;
        }
        if (node.left != null) {
            dfs(node.left, path + node.val + "->", res);
        }
        if (node.right != null) {
            dfs(node.right, path + node.val + "->", res);
        }
    }
}
