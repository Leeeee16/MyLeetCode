package com.algorithm.jianzhi.jianzhi04;

/**
 * @Description: 现在列使用二分，再在行使用二分
 * @author: lqy
 * @date: 2021/04/04/ 10:49
 */
public class Solution01 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int m_left = 0;
        int m_right = m - 1;
        while (m_left < m_right) {
            int mid = m_left + (m_right - m_left + 1) / 2;
            if (matrix[mid][0] > target) {
                m_right = mid - 1;
            } else {
                m_left = mid;
            }
        }
        for (int i = 0; i <= m_left; i++) {
            int n_left = 0;
            int n_right = n - 1;
            while (n_left < n_right) {
                int mid = n_left + (n_right - n_left) / 2;
                if (matrix[i][mid] < target) {
                    n_left = mid + 1;
                } else {
                    n_right = mid;
                }
            }
            if (matrix[i][n_left] == target) {
                return true;
            }
        }
        return false;
    }
}
