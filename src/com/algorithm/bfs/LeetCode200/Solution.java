package com.algorithm.bfs.LeetCode200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            if (curX >= 0 && curX < grid.length && curY >= 0 && curY < grid[0].length && grid[curX][curY] == '1') {
                grid[curX][curY] = '0';
                queue.add(new int[]{curX + 1, curY});
                queue.add(new int[]{curX - 1, curY});
                queue.add(new int[]{curX, curY + 1});
                queue.add(new int[]{curX, curY - 1});
            }
        }
    }
}
