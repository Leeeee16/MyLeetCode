package com.algorithm.highFreqQ.quickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/01/ 15:07
 */
public class Solution {

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
        // 递归
        quick_sort(nums, left, index);
        quick_sort(nums, index + 1, right);
    }

    /**
     * 划分，并返回pivot下标
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        // 随机取一个下标
        int randomIdx = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, randomIdx, left);

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
            // 退出条件
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

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,4,3,2,1};
        Solution s = new Solution();
        s.quick_sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
