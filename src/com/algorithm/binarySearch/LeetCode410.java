package com.algorithm.binarySearch;

public class LeetCode410 {

    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;

        // 计算 子数组各自的和的最大值 的上下界
        // 最大就是数组所有元素的和(即m=1)，最小为 数组最大的元素值
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        // 使用二分查找，确定一个恰当的 子数组各自的和的最大值
        // 使得它对应的 子数组的分割数 恰好等于 m
        int left = max, right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int splits = split(nums, mid);
            if (splits > m) {
                // 如果分割数太多，说明 子数组各自的和的最大值 太小，此时需要 增大 子数组各自的和的最大值
                // 下一轮搜索区间 [mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * @param nums           原始数组
     * @param maxIntervalSum 子数组各自的和的最大值
     * @return 满足不超过 子数组各自的最大值 的分割数
     */
    private int split(int[] nums, int maxIntervalSum) {
        // 至少是一个分割
        int splits = 1;
        // 当前区间的和
        int curIntervalSum = 0;
        for (int num : nums) {
            // 尝试加上当前遍历的这个数，如果加上后超过了 子数组各自的和的最大值，就不加这个数
            if (curIntervalSum + num > maxIntervalSum) {
                curIntervalSum = 0;
                splits++;
            }
            curIntervalSum += num;
        }
        return splits;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 2, 5, 10, 8};
        int m = 2;
        LeetCode410 lc = new LeetCode410();
        int res = lc.splitArray(nums, m);
        System.out.println(res);
    }
}
