package com.algorithm.linkedList.LeetCode445;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack_l1 = new Stack<>();
        Stack<Integer> stack_l2 = new Stack<>();

        while (l1 != null) {
            stack_l1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack_l2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        // ListNode cur = head;
        boolean flag = false;
        while (!stack_l1.isEmpty() || !stack_l2.isEmpty() || flag) {
            int a = stack_l1.isEmpty() ? 0 : stack_l1.pop();
            int b = stack_l2.isEmpty() ? 0 : stack_l2.pop();
            int c = flag ? a + b + 1 : a + b;
            // 更新进位标记
            flag = c > 9;
            ListNode cur = new ListNode(c % 10);
            cur.next = head;
            head = cur;
        }
        return head;
    }
}
