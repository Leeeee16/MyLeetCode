package com.algorithm.sort;

public class Counting_Sort {
    final static int N = 110; // 数组元素取值

    public static int[] counting_sort(int[] nums, int k) {
        int[] tmp = new int[k + 1];
        int len = nums.length;
        int[] res = new int[len];
        // 统计nums中元素个数，存入tmp数组
        for (int num : nums) {
            tmp[num]++;
        }
        // 修改tmp数组，改成小于等于当前元素的个数
        for (int i = 1; i < k + 1; i++) {
            tmp[i] += tmp[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            res[tmp[nums[i]] - 1] = nums[i];
            tmp[nums[i]]--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        int k = 99;
        int[] res = counting_sort(nums, k);
        for (int a : res) {
            System.out.print(a + " ");
        }
    }
}

