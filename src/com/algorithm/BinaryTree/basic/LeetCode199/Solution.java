package com.algorithm.BinaryTree.basic.LeetCode199;

import java.util.*;

public class Solution {
    // 层次遍历思想，右节点先入队，每层第一个入队的节点 存入 结果列表res
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.pollFirst();
                if (i == 0) {
                    res.add(curNode.val);
                }
                // 交换下面两行，则是左视图
                if (curNode.right != null) {
                    queue.addLast(curNode.right);
                }
                if (curNode.left != null) {
                    queue.addLast(curNode.left);
                }
            }
        }
        return res;
    }
}
