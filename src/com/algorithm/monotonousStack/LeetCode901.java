package com.algorithm.monotonousStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode901 {
    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        int[] input = new int[]{100, 80, 60, 70, 60, 75, 85};
        int n = 7;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = s.next(input[i]);
        }
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}

class StockSpanner {

    // 记录所有输入的股价
    private List<Integer> stockPrice;
    // 单调栈，单调不增
    private Deque<Integer> stack;
    // 记录元素下标
    private int index;

    public StockSpanner() {
        // 定义一个哨兵
        this.stockPrice = new ArrayList<>();
        stockPrice.add(10_0000 + 1);

        stack = new ArrayDeque<>();
        stack.addLast(0);
        index = 0;
    }

    public int next(int price) {
        index++;
        // 如果栈顶元素 小于等于 当前元素，移出栈顶元素
        // 注意：在单调栈中不要使用stack.peek()，它等价于peekFirst()
        while (!stack.isEmpty() && stockPrice.get(stack.peekLast()) <= price) {
            stack.removeLast();
        }
        // 返回值就是当前的下标 减去 栈顶元素的下标
        int res = index - stack.peekLast();

        stockPrice.add(price);
        stack.addLast(index);

        return res;
    }
}
