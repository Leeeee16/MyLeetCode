package com.algorithm.monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode316 {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] charArray = s.toCharArray();

        int[] lastIndex = new int[26];
        // 字母最后出现的下标
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        // 记录字母是否在栈中
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            char curChar = charArray[i];
            // 当前字母如果访问过了，则跳过
            if (visited[curChar - 'a']) {
                continue;
            }
            // 1.栈非空  2.当前字符 < 栈顶字母  3.栈顶字母在i之后还会出现
            while (!stack.isEmpty() && curChar < stack.peekLast() && lastIndex[stack.peekLast() - 'a'] > i) {
                char c = stack.removeLast();
                visited[c - 'a'] = false;
            }
            stack.addLast(curChar);
            visited[curChar - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.removeLast());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "bcabc";
        LeetCode316 lc = new LeetCode316();
        String res = lc.removeDuplicateLetters(s);
        System.out.println(res);
    }
}
