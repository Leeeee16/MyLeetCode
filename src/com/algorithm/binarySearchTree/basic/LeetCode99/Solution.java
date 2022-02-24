package com.algorithm.binarySearchTree.basic.LeetCode99;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/03/28/ 22:26
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pred = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
