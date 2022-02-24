package com.algorithm.bfs.LeetCode994;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // 新鲜橘子的个数
        int newCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    newCnt++;
                }
            }
        }
        // 如果没有橘子，返回0
        if (newCnt == 0 && queue.size() == 0) {
            return 0;
        }
        // 从烂橘子开始向外扩散
        int minutes = 0;
        while (!queue.isEmpty()) {
            // 记录当前队列长度
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for (int[] d : directions) {
                    int newX = x + d[0];
                    int newY = y + d[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.add(new int[]{newX, newY});
                        newCnt--;
                    }
                }
            }
            minutes++;
        }
        return newCnt == 0 ? minutes - 1 : -1;
    }
}
