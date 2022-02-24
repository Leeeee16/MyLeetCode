package com.algorithm.BinaryTree.basic.LeetCode145;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        // prev记录上一个访问的节点
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果右节点为空 或者 右节点访问过，则将root加入结果数组
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                // 否则root重新进栈，遍历右子树
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }
}
