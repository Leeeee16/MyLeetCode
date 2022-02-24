package com.algorithm.demo.LeetCode455;

import java.util.Arrays;


public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sLen = s.length;
        int gLen = g.length;
        if (sLen == 0) {
            return 0;
        }
        int res = 0;
        int j = 0;
        for (int cur : g) {
            while (j < sLen) {
                if (s[j] >= cur) {
                    res++;
                    j++;
                    break;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
