package com.algorithm.jianzhi.jianzhi31;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/29/ 14:26
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = popped.length;
        int i = 0;  // 下一个要入栈的元素下标
        int j = 0;  // 下一个要出栈的元素下标
        Deque<Integer> stack = new ArrayDeque<>();
        while (i < len || j < len) {
            if (stack.isEmpty() || stack.peek() != popped[j]) {
                // 栈顶 != 弹出元素，继续压栈
                while (i < len) {
                    stack.push(pushed[i++]);
                    if (stack.peek() == popped[j]) {
                        break;
                    }
                }
                // 如果所有数都入栈了，还没有找到出栈元素，返回false
                if (i == len && stack.peek() != popped[j]) {
                    return false;
                }
            }
            // 栈顶 = 要出栈的元素
            stack.pop();
            j++;
        }
        // 返回是否所有元素都出栈
        return j == len;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] poped = new int[]{3,2,4,1,5};
        Solution s31 = new Solution();
        boolean res = s31.validateStackSequences(pushed,poped);
        System.out.println(res);
    }
}
