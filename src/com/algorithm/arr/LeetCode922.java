package com.algorithm.arr;

import java.util.Arrays;

public class LeetCode922 {
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int odd = 1; // 奇数下标
        int even = 0; // 偶数下标
        while(odd < len && even < len) {
            while(odd < len && A[odd] % 2 == 1) {
                odd += 2;
            }
            while(even < len && A[even] % 2 == 0) {
                even += 2;
            }
            if(odd >= len || even >= len) {
                break;
            }
            int temp = A[odd];
            A[odd] = A[even];
            A[even] = temp;
        }
        return A;
    }

    public static void main(String[] args) {
        LeetCode922 lc = new LeetCode922();
        int[] A = new int[]{4, 2, 5, 7};
        int[] ans = lc.sortArrayByParityII(A);
        System.out.println(Arrays.toString(ans));
    }
}
