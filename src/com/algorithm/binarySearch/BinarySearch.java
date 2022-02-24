package com.algorithm.binarySearch;

/**
 * @author: lqy
 * @create: 2020/10/19
 * @description: BinarySearch
 * 二分查找
 */
public class BinarySearch {

    // 整数二分, 返回下标，不在数组中则返回-1
    public static int bsearch_1(int[] nums, int l, int r, int key) {
        if(l >= r) return -1;
        while(l < r) {
            int mid = l + r >> 1; // mid = l + (r - l) / 2;
            if(nums[mid] >= key) r = mid;
            else l = mid + 1;
        }
        return l;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13, 17, 91, 103};
        int idx = bsearch_1(nums, 0, nums.length - 1, 9);
        System.out.println(idx);
    }
}
