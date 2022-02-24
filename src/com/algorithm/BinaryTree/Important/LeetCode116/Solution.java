package com.algorithm.BinaryTree.Important.LeetCode116;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 时间：O(n)，空间：O(n)
 * @author: lqy
 * @date: 2021/03/29/ 22:41
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            Node pre = null;
            while (curSize > 0) {
                Node cur = queue.poll();
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
                curSize--;
            }
        }
        return root;
    }
}
