package com.algorithm.BinaryTree.basic.LeetCode101;

import java.util.LinkedList;

public class Solution2 {
    // 迭代解法 BFS 层次遍历
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root.left);
        queue.addLast(root.right);
        while (!queue.isEmpty()) {
            // 出队时查看是否有孩子，将孩子节点入队
            TreeNode leftNode = queue.pollFirst();
            TreeNode rightNode = queue.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if(leftNode == null || rightNode == null) {
                return false;
            }
            queue.addFirst(leftNode.right);
            queue.addFirst(leftNode.left);
            queue.addLast(rightNode.left);
            queue.addLast(rightNode.right);

            if(leftNode.val != rightNode.val) {
                return false;
            }
        }
        return true;
    }
}
