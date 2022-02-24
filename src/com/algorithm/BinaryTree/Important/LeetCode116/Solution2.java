package com.algorithm.BinaryTree.Important.LeetCode116;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/03/29/ 22:49
 */
public class Solution2 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = root;
        while (pre.left != null) {
            Node tmp = pre;
            while (tmp != null) {
                tmp.left.next = tmp.right;
                if (tmp.next != null) {
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            pre = pre.left;
        }
        return root;
    }
}
