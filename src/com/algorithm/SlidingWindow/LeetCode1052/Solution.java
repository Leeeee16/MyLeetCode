package com.algorithm.SlidingWindow.LeetCode1052;

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int sum = 0;
        int sum2 = 0;

        for (int i = 0; i < len; i++) {
            sum += customers[i];
            customers[i] *= grumpy[i];
            sum2 += customers[i];
        }
        sum -= sum2;
        // System.out.println(sum);
        int right = 0;
        int left = 0;
        int curSum = 0;

        // 初始化滑动窗口
        for (right = 0; right < X; right++) {
            curSum += customers[right];
        }
        int maxSum = curSum;
        System.out.println(right);
        while (right < len) {
            curSum = curSum + customers[right] - customers[left];
            System.out.println(curSum);
            maxSum = Math.max(curSum, maxSum);
            right++;
            left++;
        }
        // System.out.println(curSum);
        return sum + maxSum;
    }

    public static void main(String[] args) {
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
        int X = 3;
        Solution solution = new Solution();
        int ans = solution.maxSatisfied(customers, grumpy, X);
        System.out.println(ans);
    }
}