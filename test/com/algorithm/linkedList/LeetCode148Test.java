package com.algorithm.linkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode148Test {

    @Test
    public void sortList() {
        int[] input = new int[]{4, 3, 1, 2};
        ListNode head = ListNode.linkedListInit(input);
        LeetCode148 lc = new LeetCode148();
        ListNode res = lc.sortList(head);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}