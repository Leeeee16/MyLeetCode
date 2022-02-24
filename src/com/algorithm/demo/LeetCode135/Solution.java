package com.algorithm.demo.LeetCode135;

public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len < 1) {
            return 0;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        // 左到右 符合条件
        for (int i = 0; i < len; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        // 右到左 符合条件
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1 && ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int sum = 0;
        // 取 左 和 右 较大的，加入结果
        for (int i = 0; i < len; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
