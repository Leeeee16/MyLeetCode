package com.algorithm.twoPointers;

public class LeetCode28 {
    public int strStr(String haystack, String needle) {
        int tLen = haystack.length();
        int pLen = needle.length();

        if (pLen == 0) {
            return 0;
        }
        if (pLen > tLen) {
            return -1;
        }
        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        return KMP(text, pattern);
    }

    private int KMP(char[] text, char[] pattern) {
        int tLen = text.length;
        int pLen = pattern.length;

        int[] next = getNext(pattern);

        int i = 0;
        int j = 0;
        while (i < tLen) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            }
            // 匹配成功
            if (j == pLen) {
                return i - j;
            } else if (i < tLen && text[i] != pattern[j]) {
                if (j != 0) {
                    j = next[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    // 创建next数组
    private int[] getNext(char[] pattern) {
        int pLen = pattern.length;
        int[] next = new int[pLen];

        next[0] = 0;
        int i = 1;
        int j = 0;
        while (i < pLen) {
            if (pattern[i] == pattern[j]) {
                j++;
                next[i] = j;
                i++;
            } else {
                if (j == 0) {
                    next[i] = 0;
                    i++;
                } else {
                    j = next[j - 1];
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ello";
        LeetCode28 lc = new LeetCode28();
        int ans = lc.strStr(haystack, needle);
        System.out.println(ans);
    }
}
