package com.algorithm.bfs.LeetCode130;

import java.util.*;

public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        // 方向向量
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Integer> queue = new LinkedList<>();
        // 记录不被围绕的圈的坐标
        Set<Integer> set = new HashSet<>();
        // 所有边界的圈入队
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                addIdx(queue, set, 0, i, n);
            }
            if (board[m - 1][i] == 'O') {
                addIdx(queue, set, m - 1, i, n);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                addIdx(queue, set, i, 0, n);
            }
            if (board[i][n - 1] == 'O') {
                addIdx(queue, set, i, n - 1, n);
            }
        }

        // 从边界的圈出发，记录相连的圈的坐标
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            int curX = idx / n;
            int curY = idx % n;
            for (int[] d : directions) {
                int newX = curX + d[0];
                int newY = curY + d[1];
                int index = getIndex(newX, newY, n);
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && !set.contains(index) && board[newX][newY] == 'O') {
                    set.add(index);
                    queue.add(index);
                }
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !set.contains(getIndex(i, j, n))) {
                    board[i][j] = 'X';
                }
            }
        }
        System.out.println(set);
        System.out.println(queue);
    }

    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    private void addIdx(Queue<Integer> queue, Set<Integer> set, int x, int y, int n) {
        int idx = getIndex(x, y, n);
        queue.add(idx);
        set.add(idx);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}};
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
