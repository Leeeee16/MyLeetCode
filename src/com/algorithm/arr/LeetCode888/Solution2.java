package com.algorithm.arr.LeetCode888;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for(int num : A) {
            rec.add(num);
        }
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                return new int[]{x, y};
            }
        }
        return null;
    }
}
