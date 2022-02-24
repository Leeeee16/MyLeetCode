package com.algorithm.jianzhi.jianzhi40;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description: 思路就是快排
 * @author: lqy
 * @date: 2021/05/08/ 18:17
 */
public class Solution {

    private Random RANDOM = new Random();

    public int[] getLeastNumbers(int[] arr, int k) {
        // 特判
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 这里注意传入下标，所以为k-1
        return quickSort(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSort(int[] arr, int left, int right, int k) {
        int idx = partition(arr, left, right);
        System.out.println(idx);
        // 返回的下标正好为k，则返回结果
        if (idx == k) {
            return Arrays.copyOf(arr, k + 1);
        }
        // 否则根据idx的大小，判断需要继续递归左边还是右边
        return idx > k ?
                quickSort(arr, left, idx, k) :
                quickSort(arr, idx + 1, right, k);
    }

    private int partition(int[] arr, int left, int right) {
        int randomIdx = RANDOM.nextInt(right - left + 1) + left;
        swap(arr, left, randomIdx);
        int pivot = arr[left];
        int lt = left;
        int gt = right;
        while (true) {
            while (lt <= right && arr[lt] < pivot) {
                lt++;
            }
            while (gt > left && arr[gt] > pivot) {
                gt--;
            }
            if (lt >= gt) {
                break;
            }
            swap(arr, lt, gt);
            lt++;
            gt--;
        }
        swap(arr, left, gt);
        return gt;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        int k = 2;
        Solution s40 = new Solution();
        int[] res = s40.getLeastNumbers(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
