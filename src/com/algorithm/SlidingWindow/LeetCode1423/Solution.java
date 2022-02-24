package com.algorithm.SlidingWindow.LeetCode1423;

import java.util.Arrays;

public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        // 滑动窗口大小len - k
        int windowSize = len - k;
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = windowSize; i < len; i++) {
            // 滑动窗口向右移动一格，右增一格，左减一个
            sum += cardPoints[i] - cardPoints[i - windowSize];
            // 因为只需求和，因此记录最小和即可，不用记录位置
            minSum = Math.min(minSum, sum);
        }
        // 选取总和最大 = 数组和 - 窗口最小和
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
