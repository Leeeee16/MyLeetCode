package com.algorithm.dynamicProgramming.LeetCode63;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            obstacleGrid[0][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                obstacleGrid[i][0] = 1;
            } else {
                while (i < m) {
                    obstacleGrid[i][0] = 0;
                    i++;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                obstacleGrid[0][i] = 1;
            } else {
                while (i < n) {
                    obstacleGrid[0][i] = 0;
                    i++;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
