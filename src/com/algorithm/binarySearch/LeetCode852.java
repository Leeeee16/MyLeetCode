package com.algorithm.binarySearch;

public class LeetCode852 {
    public int peekIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        LeetCode852 lc = new LeetCode852();
        int[] arr = {0, 2, 1, 0};
        int res = lc.peekIndexInMountainArray(arr);
        System.out.println(res);
    }
}
