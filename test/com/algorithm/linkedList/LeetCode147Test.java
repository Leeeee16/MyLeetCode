package com.algorithm.linkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode147Test {

    @Test
    public void insertionSortList() {
        LeetCode147 lc = new LeetCode147();
        ListNode head = new ListNode(4);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        ListNode res = lc.insertionSortList(head);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}