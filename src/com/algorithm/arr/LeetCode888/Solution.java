package com.algorithm.arr.LeetCode888;

import java.util.Arrays;

public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int i;
        int j;
        int len_A = A.length;
        int len_B = B.length;
        if (len_A == 0 || len_B == 0) {
            return null;
        }
        int sum_A = 0;
        int sum_B = 0;
        for (i = 0; i < len_A; i++) {
            sum_A += A[i];
        }
        for (j = 0; j < len_B; j++) {
            sum_B += B[j];
        }
        System.out.println(sum_A);
        System.out.println(sum_B);
        for (i = 0; i < A.length; i++) {
            for (j = 0; j < B.length; j++) {
                int tmpA = sum_A - A[i] + B[j];
                int tmpB = sum_B - B[j] + A[i];
                System.out.println(tmpA);
                System.out.println(tmpB);
                if (tmpA == tmpB) {
                    return new int[]{A[i], B[j]};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1};
        int[] B = new int[]{2, 2};
        Solution s = new Solution();
        int[] res = s.fairCandySwap(A, B);
        System.out.println(Arrays.toString(res));
    }
}
