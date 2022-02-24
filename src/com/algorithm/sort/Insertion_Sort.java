package com.algorithm.sort;

import java.util.Arrays;

public class Insertion_Sort {
    // 基于交换
    public int[] insertionSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                // 插入排序稳定，此处须严格大于
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    // 基于赋值
    public int[] insertionSort_02(int[] nums) {
        int len = nums.length;
        for(int i = 1; i < len; i++) {
            int tmp = nums[i];
            int j = i;
            while(j > 0 && nums[j - 1] > tmp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Insertion_Sort i = new Insertion_Sort();
        int[] nums = new int[]{3, 2, 4, 5, 1, 9, 0, -3, -9, 2, 45};
//        int[] res = i.insertionSort(nums);
        int[] res = i.insertionSort_02(nums);
        System.out.println(Arrays.toString(res));
    }
}
