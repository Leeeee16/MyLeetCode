package com.algorithm.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode739 {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if (len == 1) {
            return new int[]{0};
        }
        int[] res = new int[len];
        // 单调栈，单点不增，记录下标
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[stack.peekLast()] < T[i]) {
                // 要出栈的元素的下标
                int index = stack.removeLast();
                // 记录res
                res[index] = i - index;
            }
            stack.addLast(i);
        }

//        while (!stack.isEmpty()) {
//            res[stack.pop()] = 0;
//        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        LeetCode739 lc = new LeetCode739();
        int[] res = lc.dailyTemperatures(T);
        for(int n : res) {
            System.out.print(n + " ");
        }
    }
}
