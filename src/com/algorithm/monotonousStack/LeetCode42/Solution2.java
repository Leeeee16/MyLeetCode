package com.algorithm.monotonousStack.LeetCode42;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: lqy
 * @create: 2020/12/7
 * @description: LeetCode42:单调栈
  */
public class Solution2 {
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int sumArea = 0;
        for (int i = 0; i < len; i++) {
            // 计算每个凹槽的面积
            while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                // 记录底部的下标
                Integer bottomIndex = stack.removeLast();
                if (stack.isEmpty()) {
                    break;
                }
                // 宽度 = 右 - 左 - 1
                int width = i - stack.peekLast() - 1;
                // 高度 = 左右较小的 - 底部的高度
                int currentHeight = Math.min(height[stack.peekLast()], height[i]) - height[bottomIndex];
                sumArea += width * currentHeight;
            }
            stack.addLast(i);
        }
        return sumArea;
    }

    public static void main(String[] args) {
        Solution2 lc = new Solution2();
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        int res = lc.trap(height);
        System.out.println("res:" + res);
    }
}
