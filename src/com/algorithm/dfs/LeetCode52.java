package com.algorithm.dfs;


/**
 * @author: lqy
 * @create: 2020/10/17
 * @description: LeetCode52
 * <p>
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 */
public class LeetCode52 {
    static boolean[] col; // 列的状态，是否被选过
    static boolean[] dg, udg; // 对角线的状态
    static int res = 0;

    static void dfs(int u, int n) {
        if (n == u) {  // 找到一种，并输出
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[i + u] && !udg[n - u + i]) {
                col[i] = dg[u + i] = udg[n - u + i] = true;
                dfs(u + 1, n);
                // 恢复现场
                col[i] = dg[u + i] = udg[n - u + i] = false;
            }
        }
    }

    public int totalNQueens(int n) {
        col = new boolean[n];
        dg = new boolean[n * 2];
        udg = new boolean[n * 2];
        dfs(0, n);
        int ans = res;
        res = 0;
        return ans;
    }

    public static void main(String[] args) {
        LeetCode52 lc = new LeetCode52();
        for (int i = 1; i <= 10; i++) {
            System.out.println(lc.totalNQueens(i));
        }
//        int ans = lc.totalNQueens(1);
//        System.out.println(ans);
    }
}
