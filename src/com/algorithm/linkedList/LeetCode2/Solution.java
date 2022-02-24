package com.algorithm.linkedList.LeetCode2;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        boolean flag = false;
        while (l1 != null || l2 != null || flag) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int c = flag ? a + b + 1 : a + b;
            // 是否进位
            flag = c > 9;
            cur.next = new ListNode(c % 10);
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return newHead.next;
    }
}
