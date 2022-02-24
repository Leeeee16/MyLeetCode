package com.algorithm.highFreqQ.reverseList;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/03/ 9:08
 */
public class Solution01 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
