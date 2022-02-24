package com.algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: lqy
 * @create: 2020/10/17
 * @description: AcWing843
  */
public class AcWing843 {
    static int N = 10;
    static int n;
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N * 2], udg = new boolean[N * 2]; // 对角线的状态
    static char[][] g = new char[N][N];


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
