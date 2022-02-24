package com.algorithm.GreedyAlgorithm.LeetCode134;

public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int i = 0;
        while (i < len) {
            int sumGas = 0;
            int sumCost = 0;
            int cnt = 0;
            while (cnt < len) {
                int j = (i + cnt) % len;
                sumGas += gas[j];
                sumCost += cost[j];
                if (sumGas < sumCost) {
                    break;
                }
                cnt++;
            }
            if (cnt == len) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
