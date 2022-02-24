package com.algorithm.BinaryTree.basic.LeetCode104;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * 使用队列，层次遍历
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode curNode = queue.poll();
                if(curNode.left != null) {
                    queue.add(curNode.left);
                }
                if(curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            // 遍历完一层后，深度 +1
            depth++;
        }
        return depth;
    }
}
