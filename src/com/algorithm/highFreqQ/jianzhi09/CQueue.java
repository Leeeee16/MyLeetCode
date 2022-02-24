package com.algorithm.highFreqQ.jianzhi09;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/03/ 15:46
 */
public class CQueue {

    private static Deque<Integer> inStack;
    private static Deque<Integer> outStack;

    public CQueue(){
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        } else if (inStack.isEmpty()){
            return -1;
        } else {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
    }
}
