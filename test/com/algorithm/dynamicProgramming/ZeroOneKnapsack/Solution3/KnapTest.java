package com.algorithm.dynamicProgramming.ZeroOneKnapsack.Solution3;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnapTest {
    @Test
    public void test() {
        int n = 5;
        int[] weight = new int[]{2, 2, 6, 5, 4};
        double[] value = new double[]{6, 3, 5, 4, 6};
        int capacity = 10;
        Knap b = new Knap(n, capacity, weight, value);
        b.BackTrack(0);
        System.out.println("背包容量为：" + n);
        System.out.println("该背包能够取到的最大价值为:" + b.maxValue);
        b.printItems(b.items);
        System.out.println("取出的方法为:");
        for (int i : b.bestWay)
            System.out.print(i + "  ");
    }

}