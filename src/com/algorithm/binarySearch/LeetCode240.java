package com.algorithm.binarySearch;

public class LeetCode240 {
    public static void main(String[] args) {
        LeetCode240 lc = new LeetCode240();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 26;
        boolean res = lc.searchMartrix_2(matrix, target);
        System.out.println(res);
    }


    // 1. 逐行遍历，每行采用二分查找
    // 时间复杂度：O(M * log N)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] < target) {
                continue;
            }
            boolean res = bsearch(matrix[i], target);
            if (res) {
                return true;
            }
        }
        return false;
    }

    public boolean bsearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target;
    }

    // 2. 迭代遍历矩阵对角线
    // 从当前元素对列和行搜索
    // 时间复杂度：O(lg(n!))O(lg(n!))
    public boolean searchMartrix_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 遍历矩阵对角线
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = bsearch_2(matrix, target, i, true);
            boolean horizontalFound = bsearch_2(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param martrix  原始数组
     * @param target   目标值
     * @param start    开始搜索的下标
     * @param vertical 判断是行搜索还是列搜索
     * @return
     */
    public boolean bsearch_2(int[][] martrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? martrix[0].length - 1 : martrix.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (vertical) {  // 搜索行
                if (martrix[start][mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else {    // 搜索列
                if (martrix[mid][start] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }
        if (vertical) {
            return martrix[start][lo] == target;
        } else {
            return martrix[lo][start] == target;
        }
    }

    // 3. 矩阵搜索
    // 时间复杂度：O(n + m)
    public boolean searchMatrix_3(int[][] matrix, int target) {
        // 从矩阵左下角开始搜索
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
