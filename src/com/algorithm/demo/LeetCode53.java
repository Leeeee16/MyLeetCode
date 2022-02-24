package com.algorithm.demo;

/**
 * @author: lqy
 * @create: 2020/10/31
 * @description: LeetCode53
 * 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class LeetCode53 {
    /**
     * 1. 递归
     * case1：[left, mid]
     * case2: [mid+1, right]
     * case3: 子区间包括mid
     * 求三种情况的最大
     * 时间复杂度：O(NlogN),递归的深度为logN,每一层都需要遍历一遍数组O(N)
     * 空间复杂度：O(logN),递归栈的深度为logN
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, nums.length - 1);
    }

    // 计算包含mid的子区间(case 3)
    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 向左遍历到头，计算以mid 结尾的最大子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        // 右边同理
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        // 左边最大 拼上 右边最大
        return leftSum + rightSum;
    }

    private int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + right >> 1;
        return max3(maxSubArraySum(nums, left, mid),
                maxSubArraySum(nums, mid + 1, right),
                maxCrossingSum(nums, left, mid, right));
    }

    private int max3(int a1, int a2, int a3) {
        return Math.max(a1, Math.max(a2, a3));
    }

    /** 2. 动态规划
     * dp[i] = max{nums[i], dp[i - 1] + nums[i]}
     * 时间复杂度：O(N),只需要遍历一次数组
     * 空间复杂度：O(1)
     */
    public int maxSubArray_dp(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int pre = nums[0];
        int res = pre;
        for (int i = 1; i < len; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            res = Math.max(res, pre);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        LeetCode53 lc = new LeetCode53();
        int res = lc.maxSubArray(nums);
//        int res = lc.maxSubArray_dp(nums);
        System.out.println(res);
    }
}
