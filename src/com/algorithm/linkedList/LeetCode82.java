package com.algorithm.linkedList;

import java.util.List;

public class LeetCode82 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode tmp = cur;
        // 添加一个新的头结点
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;

        while (tmp != null) {
            int count = 0;
            int cur_num = cur.val;
            while (tmp != null) {
                if (tmp.val == cur_num) {
                    tmp = tmp.next;
                    count++;
                } else {
                    break;
                }
            }
            if (count == 1) {
                newHead.next = cur;
                newHead = newHead.next;
            }
            cur = tmp;
            if (cur == null) {
                newHead.next = null;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
//        ListNode l6 = new ListNode(4);
//        ListNode l7 = new ListNode(5);
        head.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;
//        l7.next = null;
        ListNode res = deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
