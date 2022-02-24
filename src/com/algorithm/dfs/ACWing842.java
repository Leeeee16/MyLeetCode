package com.algorithm.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class AcWing842 {
    static int n;
    static int N = 10;
    static int[] path = new int[N]; // 保存路径
    static boolean[] st = new boolean[N]; // 结点状态

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(0);
    }

    public static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) System.out.print(path[i] + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                path[u] = i;
                st[i] = true;
                dfs(u + 1);
                st[i] = false;
            }
        }
    }
}