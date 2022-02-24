package com.algorithm.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] area = new int[len];
        // 从左向右,算出当前元素向右，最大的宽是多少（包括它自己）
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int index = stack.removeLast();
                area[index] = i - index;
            }
            stack.addLast(i);
        }
        // 从左向右，栈中剩下的元素递增，宽就等于 len - index
        while (!stack.isEmpty()) {
            int index = stack.removeLast();
            area[index] = len - index;
        }

        // 从右向左，算出当前元素向左，最大的宽是多少（包括它自己）
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int index = stack.removeLast();
                area[index] += index - i;
            }
            stack.addLast(i);
        }
        // 从右向左，剩下的元素递增，宽度等于 index + 1
        while (!stack.isEmpty()) {
            int index = stack.removeLast();
            area[index] += index + 1;
        }

        // 计算area，左右宽都算了一次元素自己，因此要减1
        int i;
        for (i = 0; i < len; i++) {
            area[i] = (area[i] - 1) * heights[i];
        }

        // 找到最大面积并返回
        int maxArea = 0;
        for (i = 0; i < len; i++) {
            if (area[i] > maxArea) {
                maxArea = area[i];
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LeetCode84 lc = new LeetCode84();
        int[] heights = new int[]{4, 2, 0, 3, 2, 4, 3, 4};
        int res = lc.largestRectangleArea(heights);
        System.out.println(res);
    }
}
