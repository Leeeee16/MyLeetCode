package com.algorithm.binarySearchTree.basic.LeetCode230;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int res = -1;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode curNode = root;
        while (!queue.isEmpty() || curNode != null) {
            while (curNode != null) {
                queue.add(curNode);
                curNode = curNode.left;
            }
            TreeNode node = queue.removeLast();
            k--;
            if (0 == k) {
                return node.val;
            }
            curNode = node.right;
        }
        return res;
    }
}
