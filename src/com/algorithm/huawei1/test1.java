package com.algorithm.huawei1;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/18/ 17:18
 */
public class test1 {

//    class Solution {
//        public ListNode method(ListNode head1, ListNode head2) {
//            boolean flag = false;
//            ListNode newHead = new ListNode();
//            ListNode dummy = new ListNode();
//            dummy.next = newHead;
//            int tmp;
//            while (head1 != null && head2 != null) {
//                if (flag == true) {
//                    tmp = head1.val + head2.val + 1;
//                } else {
//                    tmp = head1.val + head2.val;
//                }
//                if (tmp >= 10) {
//                    flag = true;
//                } else {
//                    flag = false;
//                }
//                newHead.val = tmp % 10;
//                newHead = newHead.next;
//                head1 = head1.next;
//                head2 = head2.next;
//            }
//            while (head1 != null) {
//                if (flag) {
//                    tmp = head1.val + 1;
//                } else {
//                    tmp = head1.val;
//                }
//                if (tmp >= 10) {
//                    flag = true;
//                } else {
//                    flag = false;
//                }
//                newHead.val = tmp % 10;
//                newHead = newHead.next;
//                head1 = head1.next;
//            }
//            while (head2 != null) {
//                if (flag) {
//                    tmp = head2.val + 1;
//                } else {
//                    tmp = head2.val;
//                }
//                if (tmp >= 10) {
//                    flag = true;
//                } else {
//                    flag = false;
//                }
//                newHead.val = tmp % 10;
//                newHead = newHead.next;
//                head2 = head2.next;
//            }
//            return dummy.next;
//        }
//    }


    public static void main(String[] args) {

    }
}
