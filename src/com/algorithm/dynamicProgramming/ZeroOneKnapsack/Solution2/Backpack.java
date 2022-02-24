package com.algorithm.dynamicProgramming.ZeroOneKnapsack.Solution2;

import java.util.Arrays;
import java.util.Collections;

public class Backpack {
    // 现有的物品
    private Knapsack[] bags;
    // 背包的总承重
    private int totalWeight;
    // 背包最大总价值
    private int bestValue;

    public Backpack(Knapsack[] bags, int totalWeight) {
        this.bags = bags;
        this.totalWeight = totalWeight;
        // 对背包按单位重量价值从大到小排序
        Arrays.sort(bags, Collections.reverseOrder());
    }

    public void solve() {
        int tempWeight = totalWeight;

        for (Knapsack bag : bags) {
            //判断当前物品是否可以放入背包中，若不能则继续循环，查找下一个物品
            if (tempWeight - bag.getWeight() < 0)
                continue;

            tempWeight -= bag.getWeight();
            bestValue += bag.getValue();
        }
    }

    public int getBestValue() {
        return bestValue;
    }

    public static void main(String[] args) {
        Knapsack[] bags = new Knapsack[]{
                new Knapsack(1, 1),
                new Knapsack(2, 2),
                new Knapsack(3, 2),
                new Knapsack(4, 4)};

        int totalWeight = 5;

        Backpack problem = new Backpack(bags, totalWeight);
        problem.solve();

        System.out.println(problem.getBestValue());
    }
}
