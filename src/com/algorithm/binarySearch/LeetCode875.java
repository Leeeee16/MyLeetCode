package com.algorithm.binarySearch;

public class LeetCode875 {
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0; // 记录最大元素
        // K 的取值：最小 = 1， 最大 = 最大元素
        // h 的取值：最大 = 元素和， 最小 = 元素个数
        for(int num : piles) {
            max = Math.max(max, num);
        }
        // 每小时吃的越多，小时数就越少
        // 二分，确定一个恰当的k，使得小时数刚好为 H
        int left = 1, right = max;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int h = helper(piles, mid);
            if(h > H) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;

    }

    /**
     * @param piles 原数组
     * @param k 当前每小时吃的个数
     * @return  返回需要的小时数
     */
    public int helper(int[] piles, int k) {
        int h = 0;
        for(int num : piles) {
            // 向上取整
//            h += num % k == 0? num / k : num / k + 1;
            h += (num + k - 1) / k;
        }
        return h;
    }

    public static void main(String[] args) {
        LeetCode875 lc = new LeetCode875();
        int[] piles = new int[]{30,11,23,4,20};
        int H = 6;
        int res = lc.minEatingSpeed(piles, H);
        System.out.println(res);
    }
}
