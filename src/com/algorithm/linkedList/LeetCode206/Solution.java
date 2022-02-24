package com.algorithm.linkedList.LeetCode206;

public class Solution {
    // 1 -> 2 -> 3 -> 4 -> null
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
