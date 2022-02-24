package com.algorithm.GreedyAlgorithm.LeetCode134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        // 总油量 - 总消耗
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        // 记录 gas - cost 的最低点
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            // 计算每个加油站的余量的和
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        // 如果spare > 0，解为minIndex的后一个；否则误解
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}

// 参考思路：https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
