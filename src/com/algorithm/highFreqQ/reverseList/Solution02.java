package com.algorithm.highFreqQ.reverseList;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/03/ 9:29
 */
public class Solution02 {
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
