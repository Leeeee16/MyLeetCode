package com.algorithm.bfs.LeetCode407;

import java.util.PriorityQueue;

public class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        // 标记是否被访问过
        boolean[][] visited = new boolean[m][n];
        // 优先队列存放三元组[x, y, h]坐标和高度
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>();

        // 将最外围一圈入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    priorityQueue.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int res = 0;
        // 一维方向数组
        int[] dir = {-1, 0, 1, 0, -1};
        while (!priorityQueue.isEmpty()) {
            int[] cur = priorityQueue.poll();
            // 看周围四个方向
            for (int k = 0; k < 4; k++) {
                int newX = cur[0] + dir[k];
                int newY = cur[1] + dir[k + 1];
                // 位置合法 且 未访问过
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    // 如果外围这一圈的最小比当前还高，可以注水
                    if (cur[2] > heightMap[newX][newY]) {
                        res += cur[2] - heightMap[newX][newY];
                    }
                    priorityQueue.offer(new int[]{newX, newY, Math.max(heightMap[newX][newY], cur[2])});
                    visited[newX][newY] = true;
                }
            }
        }
        return res;
    }
}
