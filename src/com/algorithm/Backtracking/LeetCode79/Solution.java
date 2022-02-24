package com.algorithm.Backtracking.LeetCode79;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/23/ 21:26
 */
public class Solution {

    private final static int[] DIRECTIONS = new int[]{-1, 0, 1, 0, -1};
    private int rows;
    private int cols;
    private int len;
    private char[][] board;
    private char[] toCharArray;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        if (rows == 0) {
            return false;
        }
        this.cols = board[0].length;
        this.board = board;
        this.len = word.length();
        this.visited = new boolean[rows][cols];
        this.toCharArray = word.toCharArray();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(int x, int y, int begin) {
        // 退出条件
        if (begin == len - 1) {
            return toCharArray[begin] == board[x][y];
        }
        if (toCharArray[begin] == board[x][y]) {
            visited[x][y] = true;
            // 向四周寻找
            for (int i = 0; i < 4; i++) {
                int newX = x + DIRECTIONS[i];
                int newY = y + DIRECTIONS[i + 1];
                if (isInArea(newX, newY) && !visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }

            visited[x][y] = false;
        }
        return false;
    }

    private boolean isInArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

}
