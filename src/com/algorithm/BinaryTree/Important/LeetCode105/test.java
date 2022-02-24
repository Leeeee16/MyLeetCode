package com.algorithm.BinaryTree.Important.LeetCode105;

import java.util.ArrayDeque;
import java.util.Deque;

public class test {


    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        // Deque的push：在 队列的 head插入元素
        // Deque的add：在队列的 尾部插入元素
        /*
        1
        21
        321
         */
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.print(stack.peekFirst() + " ");
        System.out.println(stack.peekLast());
        // 3214
        stack.add(4);
        System.out.print(stack.peekFirst() + " ");
        System.out.println(stack.peekLast());
    }
}
