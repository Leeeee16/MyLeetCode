package com.algorithm.highFreqQ.LeetCode225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/03/ 16:07
 */
public class MyStack {
    // 输入队列,输入前是空的
    private static Queue<Integer> a;
    // 输出队列
    private static Queue<Integer> b;

    /** Initialize your data structure here. */
    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        a.add(x);
        while (!b.isEmpty()) {
            a.add(b.poll());
        }
        Queue<Integer> tmp = a;
        a = b;
        b = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return b.poll();
    }

    /** Get the top element. */
    public int top() {
        return b.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return b.isEmpty();
    }

}
