package com.algorithm.arr;

public class LeetCode41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 1;
        }
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n) {
                if(nums[nums[i] - 1] == nums[i]) {
                    break;
                }
                swap(nums, nums[i] - 1, i);
            }
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        LeetCode41 lc = new LeetCode41();
        int[] nums = new int[]{3,4,-1,1};
        int res = lc.firstMissingPositive(nums);
        System.out.println(res);
    }
}
