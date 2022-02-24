package com.algorithm.BinaryTree.basic.LeetCode100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 广度优先遍历
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Deque<TreeNode> queue1 = new LinkedList<>();
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue1.addLast(p);
        queue2.addLast(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.pollFirst();
            TreeNode node2 = queue2.pollFirst();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left;
            TreeNode right1 = node1.right;
            TreeNode left2 = node2.left;
            TreeNode right2 = node2.right;

            // ^： 异或
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (left1 != null) {
                queue1.addLast(left1);
            }
            if (right1 != null) {
                queue1.addLast(right1);
            }
            if (left2 != null) {
                queue2.addLast(left2);
            }
            if (right2 != null) {
                queue2.addLast(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
