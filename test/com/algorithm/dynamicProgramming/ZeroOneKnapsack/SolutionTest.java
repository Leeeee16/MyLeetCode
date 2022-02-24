package com.algorithm.dynamicProgramming.ZeroOneKnapsack;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void maxValue() {
        int N = 5;
        int V = 10;
        int[] weight = new int[]{2, 2, 6, 5, 4};
        int[] value = new int[]{6, 3, 5, 4, 6};
        Solution s = new Solution();
        int maxValue = s.maxValue(N, V, weight, value);
        System.out.println(maxValue);
    }

    @Test
    public void maxValue2() {
        int N = 5;
        int V = 10;
        int[] weight = new int[]{2, 2, 6, 5, 4};
        int[] value = new int[]{6, 3, 5, 4, 6};
        Solution s = new Solution();
        int maxValue = s.maxValue2(N, V, weight, value);
        System.out.println(maxValue);
    }
}