package com.algorithm.linkedList;

public class LeetCode148 {
    // 思路：类似数组快排，用两个虚拟头结点，依次和pivot比较
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = middleNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return mergeTwoSortedLinkedList(left, right);
    }

    /**
     * 找到链表的中间节点：快慢指针
     * @param head：链表的头结点
     * @return 返回中间节点
     */
    private ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 合并两个有序链表
     *
     * @param l1：第一个链表的头结点
     * @param l2：第二个链表的头结点
     * @return 返回合并后的头结点
     */
    private ListNode mergeTwoSortedLinkedList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) {
            tmp.next = l1;
        }else {
            tmp.next = l2;
        }
        return res.next;
    }
}
