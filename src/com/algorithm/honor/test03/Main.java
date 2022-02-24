package com.algorithm.honor.test03;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int m = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
//        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        // 记录第i段的分界,resIdx[i]表示第i段结尾
        int[] resIdx = new int[k + 1];
        int[] res = new int[k + 1];
        helper(nums, 0, m - 1, k, resIdx, res);
        for (int i = 0; i < m; i++) {
            if (i == res[k]) {
                k--;
                System.out.print("/ ");
            }
            System.out.print(nums[i]);
            if (i != m - 1) {
                System.out.print(" ");
            }
        }
    }

    public static int helper(int[] arr, int start, int end, int k, int[] resIdx, int[] res) {
        // 只分一组,返回数组和
        if (k == 1) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += arr[i];
            }
            resIdx[k] = end;
            return sum;
        }
        // 组数=长度，即返回最小值
        if (k == (end - start + 1)) {
            int min = arr[0];
            for (int i = 0; i < k; i++) {
                min = Math.min(min, arr[i]);
                resIdx[i + 1] = i + 1;
            }
            return min;
        }

        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end + 1 - k; i++) {
            resIdx[k] = i;
            int sum = 0;
            // 第一段的和
            for (int j = start; j <= i; j++) {
                sum += arr[j];
            }
            // 所有段较小的
            int summer = Math.min(sum, helper(arr, i + 1, end, k - 1, resIdx, res));
            if (summer > max) {
                max = summer;
                System.arraycopy(resIdx, 0, res, 0, resIdx.length);
            }
        }
        return max;
    }
}
