package com.algorithm.dynamicProgramming.LeetCode62;

class Solution3 {
    public int uniquePaths(int m, int n) {
        // 只需移动 m + n - 2 次，向下 m - 1 次，向右 n - 1 次
        // 排列组合 C m+n-2  n-1
        // (m + n - 2)! / ((m - 1)! * (n - 1)!)
        long ans = 1;
        for (int i = n, j = 1; j < m; i++, j++) {
            ans = ans * i / j;
        }
        return (int) ans;
    }
}
