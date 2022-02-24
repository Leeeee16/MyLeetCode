package com.algorithm.linkedList.LeetCode92;


public class Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 需翻转子链表头结点的前一个节点
        ListNode p1 = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            p1 = p1.next;
        }
        // 需翻转子链表的尾结点
        ListNode p2 = p1;
        for (int i = 0; i < right - left + 1; i++) {
            p2 = p2.next;
        }
        // 需翻转子链表的头结点
        ListNode p3 = p1.next;
        // 需翻转子链表的尾结点的后一个节点
        ListNode p4 = p2.next;
        p1.next = null;
        p2.next = null;
        // 翻转子链表
        reverseList(p3);
        // 接回原链表
        p1.next = p2;
        p3.next = p4;

        return dummyNode.next;

    }

    // 翻转整个链表
    private void reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}
