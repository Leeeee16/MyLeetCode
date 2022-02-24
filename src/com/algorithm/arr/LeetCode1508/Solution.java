package com.algorithm.arr.LeetCode1508;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int len = nums.length;
        final int MODULO = 1000000007;
//        List<Integer> subSum = new ArrayList<>();
        int sumsLength = len * (len + 1) / 2;
        int[] subSum = new int[sumsLength];
        int index = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
//                subSum.add(sum);
                subSum[index] = sum;
                index++;
            }
        }
//        subSum.sort(Comparator.comparingInt(o -> o));
        Arrays.sort(subSum);
//        System.out.println(subSum.toString());
        int res = 0;
        for(int i = left - 1; i < right; i++) {
            res = (res + subSum[i]) % MODULO;
        }
        return res;
    }
}
