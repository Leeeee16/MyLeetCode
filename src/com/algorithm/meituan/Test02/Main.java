package com.algorithm.meituan.Test02;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/11/ 9:13
 */
public class Main {
    public static int find(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // M队
        int n = 4;
        // T队
        int m = 3;

        int[] dis_M = new int[]{2, 3,8, 9};
        int[] dis_T = new int[]{4, 5, 7};

        Arrays.sort(dis_M);
        Arrays.sort(dis_T);
        // 最大分差
        int res = 0;
        int scoreM = 0;
        int scoreT = 0;
        // 特判
        if (dis_M[0] != 1 && dis_T[0] != 1) {
            res = Math.max(res, m - n);
        }
        if (dis_M[n - 1] != 1000 && dis_T[m - 1] != 1000) {
            res = Math.max(res, (m - n) * 2);
        }
        // m队
        for (int i = 0; i < n; i++) {
            int d = dis_M[i];
            scoreM = i + 1 + (n - i - 1) * 2;
            int idx = find(dis_T, d);
            scoreT = idx + (m - idx) * 2;
            res = Math.max(res, scoreT - scoreM);
        }
        // t队
        for (int i = 0; i < m; i++) {
            int d = dis_T[i];
            scoreT = i + 1 + (m - i - 1) * 2;
            int idx = find(dis_M, d);
            scoreM = idx + (n - idx) * 2;
            res = Math.max(res, scoreT - scoreM);
        }

        System.out.println(res);
    }
}
