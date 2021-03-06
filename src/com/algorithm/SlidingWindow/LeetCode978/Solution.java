package com.algorithm.SlidingWindow.LeetCode978;

public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int re = 1;
        int left = 0;
        int right = 0;

        while (right < n - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]){
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            re = Math.max(re, right - left + 1);
        }
        return re;
    }
}
