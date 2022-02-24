package com.algorithm.linkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 将数组转化为链表
     * @param input：输入的数组
     * @return 返回链表的头结点
     */
    static ListNode linkedListInit(int[] input) {
        if(input == null) {
            throw new IllegalArgumentException("输入为null");
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int j : input) {
            cur.next = new ListNode(j);
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }

}
