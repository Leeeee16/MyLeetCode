package com.algorithm.linkedList.LeetCode203;

/**
 * @author: lqy
 * @create: 2021/3/7
 * @description: Solution2：递归解
  */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }
}
