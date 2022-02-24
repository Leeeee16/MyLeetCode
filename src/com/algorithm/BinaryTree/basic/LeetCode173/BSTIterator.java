package com.algorithm.BinaryTree.basic.LeetCode173;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();

        TreeNode curNode = root;
        while(curNode != null) {
            stack.add(curNode);
            curNode = curNode.left;
        }
    }

    /**
     * @return 返回最小的数
     */
    public int next() {
        TreeNode top = stack.removeLast();
        if(top.right != null) {
            TreeNode p = top.right;
            while(p != null) {
                stack.addLast(p);
                p = p.left;
            }
        }
        return top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
