package com.algorithm.bfs.LeetCode130;

public class Solution2 {
    private final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;


        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]=='*') {
                    board[i][j]='O';
                } else if (board[i][j]=='O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int x, int y) {
        board[x][y] = '*';
        for (int[] d : directions) {
            int newX = x + d[0];
            int newY = y + d[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length
                    && board[newX][newY] == 'O') {
                dfs(board, newX, newY);
            }
        }
    }
}
