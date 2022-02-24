package com.algorithm.BinaryTree.basic.LeetCode107;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            while (curSize > 0) {
                TreeNode curNode = queue.poll();
                curLevel.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if(curNode.right != null) {
                    queue.add(curNode.right);
                }
                curSize--;
            }
            res.addFirst(curLevel);
        }
        return res;
    }
}
