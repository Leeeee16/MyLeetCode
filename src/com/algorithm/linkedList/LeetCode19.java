package com.algorithm.linkedList;

public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre_head = new ListNode(0, head); // 头结点
        ListNode pre = pre_head; // pre指向倒数第n个结点的前一个结点
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            pre = pre.next;
            fast = fast.next;
        }
        // 删除倒数第n个结点
        pre.next = pre.next.next;
        return pre_head.next;
    }
}
