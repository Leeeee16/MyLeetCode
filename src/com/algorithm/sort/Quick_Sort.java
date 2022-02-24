package com.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: lqy
 * @create: 2020/10/6
 * @description: Quick_Sort
 */
public class Quick_Sort {
    public static void quick_sort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l - 1, j = r + 1; // 为了后面循环，设置边界
        int pivot = q[l + r >> 1]; // 定义中轴数
        while (i < j) {
            do i++; while (q[i] < pivot);
            do j--; while (q[j] > pivot);
            if (i < j) { // 交换
                int tmp = q[i];
                q[i] = q[j];
                q[j] = tmp;
            }
        }
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 读入数组的长度
        // -2 1 -3 4 -1 2 1 -5 4
        String[] s = br.readLine().split(" "); //  读入数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]); // 将字符串数组转换为int数组
        }
        quick_sort(nums, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");    // 输出排序后的结果
        }
    }
}
