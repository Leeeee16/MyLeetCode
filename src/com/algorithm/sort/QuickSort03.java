package com.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/03/26/ 15:14
 */
public class QuickSort03 {

    private final static Random RANDOM = new Random();

    public void quick_sort(int[] nums) {
        if (nums == null) {
            return;
        }
        quick_sort(nums, 0, nums.length - 1);
    }

    private void quick_sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(nums, left, right);
        quick_sort(nums, left, index);
        quick_sort(nums, index + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int randomIdx = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIdx);

        int pivot = nums[left];
        int lt = left;
        int gt = right;
        // [left, lt) < pivot
        // (gt, right] > pivot
        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }
            while (gt > left && nums[gt] > pivot) {
                gt--;
            }
            if (lt >= gt) {
                break;
            }
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, gt);
        return gt;

    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    public static void main(String[] args) throws IOException {
        int[] nums = new int[]{3, 2, 1};
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int n = input.length;
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(input[i]);
//        }

        QuickSort03 qs3 = new QuickSort03();
        qs3.quick_sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
