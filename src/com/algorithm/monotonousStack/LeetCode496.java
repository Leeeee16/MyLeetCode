package com.algorithm.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LeetCode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len2 = nums2.length;
        // 特判
        if (len2 == 0) {
            return new int[0];
        }
        int len1 = nums1.length;
        int[] res = new int[len1];
        // 记录  数字 + 下一个更大的数字
        // 使用HashMap方便之后计算res
        Map<Integer, Integer> next = new HashMap<>();
        // 单调栈，单调不增
        Deque<Integer> stack = new ArrayDeque<>();
        // 先计算next数组
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                next.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }
        // 如果最后数字单调不增,对应next值为-1
        while(!stack.isEmpty()) {
            next.put(stack.removeLast(), -1);
        }
        // 计算res
        for (int i = 0; i < len1; i++) {
            res[i] = next.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode496 lc = new LeetCode496();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] res = lc.nextGreaterElement(nums1, nums2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
