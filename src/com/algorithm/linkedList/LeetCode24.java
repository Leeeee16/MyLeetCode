package com.algorithm.linkedList;

public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0, head);
        if (head == null || head.next == null) return head;
        ListNode t = pre;
        while (t.next != null && t.next.next != null) {
            ListNode s = t.next;
            ListNode f = t.next.next;
            t.next = f;
            s.next = f.next;
            f.next = s;
            t = t.next.next;
        }
        return pre.next;
    }
}
