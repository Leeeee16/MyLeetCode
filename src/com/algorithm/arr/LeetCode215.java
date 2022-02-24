package com.algorithm.arr;

public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int idx = partition(nums, left, right);
            if (idx == target) {
                return nums[target];
            } else if (idx > target) {
                right = idx - 1;
            } else {
                left = idx + 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        swap(nums, left, mid);
        int pivot = nums[left];
        int lo = left + 1;
        int hi = right;
        while (true) {
            while (lo <= hi && nums[lo] < pivot) {
                lo++;
            }
            while (lo <= hi && nums[hi] > pivot) {
                hi--;
            }
            if (lo > hi) {
                break;
            }
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
        // 这里区间[left + 1, hi]内是小于pivot的数，右区间是hi，因为最后做了hi--
        // 将nums[left]也就是pivot，与nums[hi]交换
        // 那么区间[left, hi - 1]内的数都小于nums[hi]
        swap(nums, left, hi);
        return hi;
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        LeetCode215 lc = new LeetCode215();
        int[] nums = new int[]{3, 1, 2, 4};
        int k = 2;
        int res = lc.findKthLargest(nums, k);
        System.out.println(res);
    }
}
