package com.algorithm.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode402 {
    public String removeKdigits(String num, int k) {
       int len = num.length();
       if(len <= k) {
           return "0";
       }

       char[] charArray = num.toCharArray();
       Deque<Character> stack = new ArrayDeque<>();
        for (char c : charArray) {
            while(k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                char x = stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }

        // 如果栈大小 > 需返回的长度，从栈顶删除多余元素
        while(stack.size() > len - k) {
            stack.removeLast();
        }

        // 如果栈底为0，则需要移除
        while(!stack.isEmpty() &&  stack.peekFirst() == '0') {
            stack.removeFirst();
        }
        
        if(stack.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0,stack.removeLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num = "13243546576879";
        int k = 6;
        LeetCode402 lc = new LeetCode402();
        String res = lc.removeKdigits(num, k);
        System.out.println(res);
    }
}
