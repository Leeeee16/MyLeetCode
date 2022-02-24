package com.algorithm.linkedList.LeetCode86;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLarge = new ListNode(-1);
        ListNode dummySmall = new ListNode(-1);

        ListNode p1 = dummySmall;
        ListNode p2 = dummyLarge;

        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p1.next = dummyLarge.next;
        p2.next = null;
        return dummySmall.next;
    }
}
