package com.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: lqy
 * @create: 2020/10/7
 * @description: ACWing788
 * 求逆序对个数
 */
public class ACWing788 {
    static int N = 100010;
    static int[] tmp = new int[N]; // 归并排序的辅助数组

    public static long merge_sort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = l + r >> 1;
        long res = merge_sort(nums, l, mid) + merge_sort(nums, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else {
                res += mid - i + 1; // 逆序元素，一个在左边，一个在右边的情况
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];

        for(i = l, j = 0; i <= r; i++, j++) nums[i] = tmp[j];
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入数组的长度：");
        int n = Integer.parseInt(br.readLine());
        System.out.println("输入数组：");
        String[] s = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(s[i]);
        long res = merge_sort(nums, 0, n - 1);
        System.out.println("逆序对的数量为:" + res);
        br.close();
    }
}
