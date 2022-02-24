package com.algorithm.BinaryTree.basic.LeetCode109;

public class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
