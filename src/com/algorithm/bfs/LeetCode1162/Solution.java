package com.algorithm.bfs.LeetCode1162;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int maxDistance(int[][] grid) {
        int N = grid.length;
        // 方向向量
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 所有陆地入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(getIndex(i, j, N));
                }
            }
        }
        int size = queue.size();
        // 如果全是陆地或者全是海洋，返回-1
        if (size == 0 || size == N * N) {
            return -1;
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int curQueSize = queue.size();
            for (int i = 0; i < curQueSize; i++) {
                int curIdx = queue.poll();
                int curX = curIdx / N;
                int curY = curIdx % N;
                for (int[] direction : directions) {
                    int newX = curX + direction[0];
                    int newY = curY + direction[1];
                    if (newX >= 0 && newX < N && newY >= 0 && newY < N && grid[newX][newY] == 0) {
                        grid[newX][newY] = 1;
                        queue.add(getIndex(newX, newY, N));
                    }
                }
            }
            step++;
        }
        return step - 1;
    }

    // 二维坐标转一维坐标
    private int getIndex(int x, int y, int N) {
        return x * N + y;
    }
}
