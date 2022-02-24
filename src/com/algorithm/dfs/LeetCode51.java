package com.algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: lqy
 * @create: 2020/10/17
 * @description: LeetCode51
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的n皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

  */
public class LeetCode51 {
    static int n;
    static boolean[] col;
    static boolean[] dg, udg; // 对角线的状态
    static char[][] g;


    static void dfs(int u) {
        if(n == u) {  // 找到一种，并输出
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(g[i][j]);
                }
                System.out.println();
            }
            System.out.println();

            return;
        }

        for (int i = 0; i < n; i++) {
            if(!col[i]  && !dg[i + u] && !udg[n - u + i]) {
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[n - u + i] = true;
                dfs(u + 1);
                // 恢复现场
                col[i] = dg[u + i] = udg[n - u + i] = false;
                g[u][i] = '.';
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)  g[i][j] = '.';
        dfs(0);

        br.close();
    }
}
