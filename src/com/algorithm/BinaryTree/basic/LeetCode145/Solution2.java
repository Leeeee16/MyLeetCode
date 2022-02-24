package com.algorithm.BinaryTree.basic.LeetCode145;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 右节点为空表示当前为叶节点，右节点为pre表示右子树已经遍历过了
            if (root.right == null || root.right == pre) {
                res.add(root.val);
                pre = root;
                root = null;
            } else {
                // 表示右节点不为空且没遍历过
                // 将当前节点重新压回栈中，遍历右子树
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
