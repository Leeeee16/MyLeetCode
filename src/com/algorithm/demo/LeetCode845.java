package com.algorithm.demo;

public class LeetCode845 {
    public int longestMountain(int[] A) {
        int length = A.length;
        if (length < 3) return 0;
        int max_len = 0; // 记录当前最长山脉的长度
        // 判断以当前i为起点的最长山脉
        for (int i = 0; i < length - 2; i++) {
            int up_len = 1;
            int down_len = 0;
            int tmp_len = 0;
            while (A[i] < A[i + 1] && i < length - 2) {
                i++;
                up_len++;
            }
            while (i < length - 1 && A[i] > A[i + 1] && up_len > 1) {
                i++;
                down_len++;
            }
            if (down_len == 0) {
                continue;
            } else {
                tmp_len = up_len + down_len;
                i--;
            }
            if (tmp_len >= 3) {
                max_len = Math.max(up_len + down_len, max_len);
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        int[] A = {4,3,2,3,4,1};
        LeetCode845 lc = new LeetCode845();
        int res = lc.longestMountain(A);
        System.out.println(res);
    }
}
