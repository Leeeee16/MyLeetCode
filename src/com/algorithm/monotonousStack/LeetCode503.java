package com.algorithm.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        // 特判
        if (len == 0) {
            return new int[0];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[len];
        // 第一次遍历
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                res[stack.removeLast()] = nums[i];
            }
            stack.addLast(i);
        }
        // 如果栈非空，再循环一次,第二次循环不需要压栈
        // 只需要找到是否存在比当前栈内更大的数字
        if(!stack.isEmpty()) {
            for (int i = 0; i < len; i++) {
                while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
                    res[stack.removeLast()] = nums[i];
                }
            }
        }
        // 如果栈非空，则res值为-1
        while(!stack.isEmpty()) {
            res[stack.removeLast()] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode503 lc = new LeetCode503();
        int[] nums = new int[]{1, 2, 3, 1};
        int[] res = lc.nextGreaterElements(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
