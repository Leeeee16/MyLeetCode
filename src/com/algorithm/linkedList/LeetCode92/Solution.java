package com.algorithm.linkedList.LeetCode92;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            // 注意这里pre.next 不是 cur
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
