package com.algorithm.BinaryTree.Important.LeetCode94;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            // 不断向左走，直到为null
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 栈顶元素出栈
            TreeNode node = stack.pop();
            // 加入结果列表
            list.add(node.val);
            // 如果有右孩子，则向右走
            cur = node.right;

        }
        return list;
    }
}
