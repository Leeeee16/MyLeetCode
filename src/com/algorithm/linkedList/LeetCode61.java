package com.algorithm.linkedList;

public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode j = head;
        int count = 1;
        // j停在最后一个节点处
        while (j.next != null) {
            j = j.next;
            count++;
        }
        // 连成循环链表
        j.next = head;

        if (count <= k) {
            k = k % count;
        }
        // 旋转后的头结点,倒数第k个，定位到它前一个
        for (int i = 0; i < count - k - 1; i++) {
            head = head.next;
        }
        j = head.next;
        head.next = null;
        return j;
    }
}
