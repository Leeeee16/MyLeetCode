package com.algorithm.linkedList.LeetCode328;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);

        ListNode L = odd;
        ListNode R = even;

        ListNode cur = head;
        boolean isOdd = true;
        while (cur != null) {
            if (isOdd) {
                L.next = cur;
                L = L.next;
            } else {
                R.next = cur;
                R = R.next;
            }
            isOdd = !isOdd;
            cur = cur.next;
        }

        L.next = even.next;
        R.next = null;
        return odd.next;
    }
}
