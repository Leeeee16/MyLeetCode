package com.algorithm.highFreqQ.quickSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/03/ 9:31
 */
public class Qs {

    private final static Random RANDOM = new Random();

    public void qs(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        qs(nums, 0, nums.length - 1);
    }

    private void qs(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(nums, left, right);
        qs(nums, left, index);
        qs(nums, index + 1, right);
    }

    /**
     * 返回一趟快排后pivot的下标
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        // 随机取一个下标
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

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 5, 6, 1, 3, 4, 3, 2, 1, 0};
        Qs q = new Qs();
        q.qs(nums);
        System.out.println(Arrays.toString(nums));
    }
}
