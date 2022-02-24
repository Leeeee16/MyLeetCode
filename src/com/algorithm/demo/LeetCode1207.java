package com.algorithm.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        for (int j : arr) {
            count[1000 + j]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int value : count) {
            if (value == 0) {
                continue;
            }
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        LeetCode1207 lc = new LeetCode1207();
        boolean res = lc.uniqueOccurrences(arr);
        System.out.println(res);
    }
}
