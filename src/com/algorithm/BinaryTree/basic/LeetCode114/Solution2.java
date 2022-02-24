package com.algorithm.BinaryTree.basic.LeetCode114;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归前序遍历
 */
public class Solution2 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        for(int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
