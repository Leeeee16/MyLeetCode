package com.algorithm.jianzhi.jianzhi14_1;

import java.util.Arrays;

/**
 * @Description: 自顶向下
 * @author: lqy
 * @date: 2021/04/25/ 10:14
 */
public class Solution2 {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        // 记忆数组，记录已经算过的状态
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        mem[2] = 1;
        return integerBreak(n, mem);
    }

    private int integerBreak(int n, int[] mem) {
        if (n == 2) {
            return 1;
        }
        if (mem[n] != -1) {
            return mem[n];
        }
        int res = 0;
        for (int i = 1; i <= n / 2; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * integerBreak(n - i, mem)));
        }
        mem[n] = res;
        return res;
    }
}
