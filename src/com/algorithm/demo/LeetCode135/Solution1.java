package com.algorithm.demo.LeetCode135;

class Solution1 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        // 从左到右 满足条件
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0;
        int res = 0;
        // 从右到左满足条件
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            res += Math.max(left[i], right);
        }
        return res;
    }
}
