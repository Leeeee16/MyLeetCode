package com.algorithm.jianzhi.jianzhi31;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/29/ 14:39
 */
public class Solution2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
