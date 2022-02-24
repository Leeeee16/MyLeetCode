package com.algorithm.binarySearch;

import java.util.Arrays;

public class LeetCode1300 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int lo = 0, hi = arr[arr.length - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            int sum_l = helper(arr, mid - 1, target);
            int sum_m = helper(arr, mid, target);
            int sum_r = helper(arr, mid + 1, target);
            if (sum_l > sum_m) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    // 计算数组和 与 target 的绝对值
    public int helper(int[] arr, int value, int target) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.min(num, value);
        }
        return Math.abs(sum - target);
    }

    public static void main(String[] args) {
        LeetCode1300 lc = new LeetCode1300();
//        int[] arr = {2, 3, 5};
//        int[] arr = {4, 3, 9};
        int[] arr = {60864, 25176, 27249, 21296, 20204};
//        int target = 10;
        int target = 56803;
        int res = lc.findBestValue(arr, target);
        System.out.println(res);
    }
}
