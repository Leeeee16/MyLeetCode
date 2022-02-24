package com.algorithm.demo;

public class LeetCode1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] bucket = new int[101];
        for (int num : nums) {
            bucket[num]++;
        }
        int ans = 0;//记录小于当前数字的数量
        for (int i = 0; i < bucket.length; i++) {
            int temp = bucket[i]; // 当前数字的个数
            bucket[i] = ans; // 将小于当前数字的数量 赋给它
            ans += temp; // 更新ans
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = bucket[nums[i]];
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1365 lc = new LeetCode1365();
        int[] nums = {8, 1, 2, 2, 3};
        int[] ans = lc.smallerNumbersThanCurrent(nums);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
