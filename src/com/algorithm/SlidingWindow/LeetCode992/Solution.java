package com.algorithm.SlidingWindow.LeetCode992;

import java.util.*;

public class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostWithKDistinct(A, K) - atMostWithKDistinct(A, K - 1);
    }

    /**
     * 最多包含 k 个不同整数的子区间的个数
     *
     * @param A
     * @param K
     * @return
     */
    private int atMostWithKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];
        int left = 0;
        int right = 0;
        // [left, right) 里不同整数的个数
        int count = 0;
        int res = 0;

        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 1, 2, 3};
        int K = 2;
        Solution s = new Solution();
        int ans = s.subarraysWithKDistinct(A, K);
        System.out.println(ans);
    }
}
