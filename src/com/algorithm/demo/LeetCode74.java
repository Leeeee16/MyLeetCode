package com.algorithm.demo;

public class LeetCode74 {
    // row = idx / n  ,col = idx % n

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // m行
        if (m == 0) return false;
        int n = matrix[0].length; // n列

        // 二分
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            int element = matrix[mid / n][mid % n];
            if (element == target) return true;
            else if (element > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int[][] a = {{1}};
        int target = 1;
        boolean res = searchMatrix(a, target);
        System.out.println(res);
    }
}
