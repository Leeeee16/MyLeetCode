package com.algorithm.BinaryTree.Important.LeetCode105;

import java.util.Deque;
import java.util.LinkedList;

public class Solution4 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("输入参数有错");
        }
        if (preLen == 0) {
            return null;
        }
        // 根节点
        TreeNode root = new TreeNode(preorder[0]);
        // 辅助栈
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        // inorder的index游标
        int inorderIndex = 0;
        // 遍历preorder里的数
        for (int i = 1; i < preLen; i++) {
            int preorderVal = preorder[i];
            // 栈顶元素
            TreeNode node = stack.peekFirst();
            // 当前节点值 != index，当前节点入栈，继续向左遍历
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                // 栈顶节点 = index,弹栈 并且 index++
                while (!stack.isEmpty() && stack.peekFirst().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                // index != 栈顶节点
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
