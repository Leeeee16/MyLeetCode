package com.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: lqy
 * @create: 2020/10/6
 * @description: Merge_Sort
 */

public class Merge_Sort {
    static int N = 100010;
    static int[] tmp = new int[N];  // 定义一个辅助数组，暂时存放两个子数组合并后的结果

    public void merge_sort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        merge_sort(nums, l, mid);
        merge_sort(nums, mid + 1, r);
        mergeTwoSortedArray(nums, l, r, mid);
    }

    private void mergeTwoSortedArray(int[] nums, int left, int right, int mid) {
        // 辅助数组下标
        int k = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k] = nums[i];
                i++;
            } else {
                tmp[k] = nums[j];
                j++;
            }
            k++;
        }
        // 如果左边没遍历完，继续遍历
        while (i <= mid) {
            tmp[k] = nums[i];
            k++;
            i++;
        }
        // 如果右边没遍历完，继续遍历
        while (j <= right) {
            tmp[k] = nums[j];
            k++;
            j++;
        }
        // 将辅助数组的数 重新赋值给原数组
        for (i = left, j = 0; i <= right; i++, j++) {
            nums[i] = tmp[j];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 4, 2, 1, -9, -3, -5, 11, 3};
        Merge_Sort solution = new Merge_Sort();
        solution.merge_sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));

    }
}
