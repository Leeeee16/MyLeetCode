package com.algorithm.jianzhi.jianzhi13;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/24/ 21:37
 */
public class Solution {

    private boolean[][] visited;
    private int m;
    private int n;

    public int movingCount(int m, int n, int k) {
        this.visited = new boolean[m][n];
        this.m = m;
        this.n = n;
        return dfs(0, 0, k);
    }

    private int dfs(int x, int y, int k) {
        if (!isInArea(x, y) || visited[x][y] || !check(x, y, k)) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y, k) + dfs(x, y + 1, k);
    }

    // 判断是否在方格内
    private boolean isInArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // false表示不符合条件
    private boolean check(int x, int y, int k) {
        return (x % 10 + x / 10 + y % 10 + y / 10) <= k;
    }
}
