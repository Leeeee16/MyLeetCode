package com.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/03/20/ 17:02
 */
public class Quick_Sort02 {

    // 列表大小小于或等于该值，优先使用插入排序
    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    /**
     * 快排
     *
     * @param nums
     * @param left
     * @param right
     */
    private void quickSort(int[] nums, int left, int right) {
        // 判断数组长度，小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertSort(nums, left, right);
            return;
        }
        int idx = partition(nums, left, right);
        quickSort(nums, left, idx);
        quickSort(nums, idx + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        // 随机选择pivot，降低递归树不平衡的情况
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        // 将randomIndex的数和left的数交换
        swap(nums, randomIndex, left);

        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;
        // [left + 1, lt) <= pivot
        // (rt, right] >= pivot
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

    /**
     * 交换数组中的两个数
     *
     * @param nums
     * @param x
     * @param y
     */
    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    /**
     * 插入排序
     *
     * @param nums
     * @param left
     * @param right
     */
    private void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            // 当前需要插入的数
            int temp = nums[i];
            int j = i;
            // 遍历找到插入的位置，如果比当前数大，则向后移动
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
//        int[] nums = new int[]{9, 8, 5, 3, 3, 4, 5, 1, 3, 2};
        Quick_Sort02 q = new Quick_Sort02();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] arr = bf.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        q.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
