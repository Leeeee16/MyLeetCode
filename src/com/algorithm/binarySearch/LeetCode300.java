package com.algorithm.binarySearch;

import java.util.Arrays;

public class LeetCode300 {
    /**
     * 1. 动态规划
     * 状态：dp[i]表示：以nums[i]结尾的 上升子序列 的长度
     * 状态转移方程：dp[i] = max{1 + dp[j] for j < i if nums[j] > nums[i]}
     * 时间复杂的：O(N^2)
     * 空间复杂度：O(N)
     */
    public int lengthOfLIS_dp(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 2. 修改状态定义（贪心 + 二分）
     */
    public int lengthOfLIS_2(int[] nums) {
        int len = nums.length;
        if(len <= 1) {
            return len;
        }
        // tail数组的定义：长度为i+1的上升子序列的末尾最小是几
        int[] tail = new int[len];
        tail[0] = nums[0];
        // end表示有序数组tail的最后一个已经赋值的索引
        int end = 0;
        for (int i = 1; i < len; i++) {
            // 比tail数组实际有效的末尾的那个元素还大
            if(nums[i] > tail[end]) {
                // 直接添加在那个元素的后面，end先+1
                end++;
                tail[end] = nums[i];
            }else {
                // 使用二分查找，在有序数组tail中
                // 找到第一个大于等于nums[i]的元素，尝试让那个元素更小
                int left = 0, right = end;
                while(left < right) {
                    int mid = left + (right - left) / 2;
                    if(tail[mid] < nums[i]) {
                        // 中位数肯定不是要找的数，把他算进分支前面
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
                // 因此，无需再单独判断
                tail[left] = nums[i];
            }
        }
        // 此时end是有序数组tail最后一个元素的索引
        // 题目要求返回的是长度，因此为end++
        end++;
        return end;
    }
    public static void main(String[] args) {
        LeetCode300 lc = new LeetCode300();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//        int res = lc.lengthOfLIS_dp(nums);
        int res = lc.lengthOfLIS_2(nums);
        System.out.println(res);
    }
}
