package com.algorithm.monotonousStack.LeetCode42;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int len = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                // 栈顶 < 当前
                int index = stack.removeLast();
                // 如果栈顶元素一直相等，需要全部pop出去
                while (!stack.isEmpty() && height[index] == height[stack.peekLast()]) {
                    stack.removeLast();
                }
                if (!stack.isEmpty()) {
                    // 当前栈顶元素
                    int stackTop = stack.peekLast();
                    // 灌水的高度为 栈顶和右边界height[i]的较小值 - height[index]
                    // 灌水的宽度为 i - stackTop - 1
                    ans += (Math.min(height[stackTop], height[i]) - height[index]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
