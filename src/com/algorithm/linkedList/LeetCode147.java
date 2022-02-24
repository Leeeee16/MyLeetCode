package com.algorithm.linkedList;

public class LeetCode147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode cur = head;
        while (tail.next != null) {
            cur = tail.next;
            ListNode x = dummy;
            while (x != null && cur.val >= x.val) {
                // 找到插入位置，插入，停止循环
                if (x.next != null && cur.val < x.next.val) {
                    tail.next = cur.next;
                    cur.next = x.next;
                    x.next = cur;
                    break;
                } else if(x == tail) {
                    // 当前节点是最大的，向后移动指针
                    tail = tail.next;
                    break;
                } else {
                    x = x.next;
                }

            }
        }
        return dummy.next;
    }
}
