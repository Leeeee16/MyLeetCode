package com.algorithm.binarySearch;

/**
 * @author: lqy
 * @create: 2020/10/30
 * @description: LeetCode4
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的中位数。
 * 时间复杂度为 O(log(m + n))
 */
public class LeetCode4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        LeetCode4 lc = new LeetCode4();
        double res1 = lc.findMedianSortedArrays_bs(nums1, nums2);
//        double res2 = lc.findMedianSortedArrays_3(nums1, nums2);
        System.out.println(res1);
//        System.out.println(res2);
    }

    /**
     * 1. 二分查找
     * 时间复杂度：O(log( min(m,n) )),对较短长度的数组进行二分
     * 空间复杂度：O(1)
     */
    public double findMedianSortedArrays_bs(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 对较短数组进行二分
        if (len1 > len2) return findMedianSortedArrays_bs(nums2, nums1);
        int len = len1 + len2;
        // 某一个数组为空，直接计算
        if (len1 == 0) return (nums2[(len2 - 1) / 2] + nums2[len2 / 2]) / 2.0;
        // 初始化二分边界
        int i = 0, j = 0;
        int low = 0, high = len1;
        double res = 0;
        while (low <= high) {
            // 对nums1数组做partition
            i = (low + high + 1) / 2;
            j = (len + 1) / 2 - i;
            double L1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            double R1 = i == len1 ? Integer.MAX_VALUE : nums1[i];
            double L2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            double R2 = j == len2 ? Integer.MAX_VALUE : nums2[j];
            // 判断是否满足条件
            if (L1 <= R2 && L2 <= R1) {
                // 偶数
                if ((len1 + len2) % 2 == 0) {
                    res = (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    // 奇数
                    res = Math.max(L1, L2);
                }
                break;
            } else if (L1 > R2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        return res;
    }

    /**
     * 2. 归并
     * 时间复杂度：O(m + n)，需要遍历两个数组
     * 空间复杂度：O(m + n)，需要辅助数组，保存归并后的两个数组
     */
    public double findMedianSortedArrays_ms(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0, k = 0;
        int[] tmp = new int[len1 + len2];
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) tmp[k++] = nums1[i++];
            else tmp[k++] = nums2[j++];
        }
        while (i < len1) tmp[k++] = nums1[i++];
        while (j < len2) tmp[k++] = nums2[j++];

        if (k % 2 == 0) return (tmp[(k - 1) / 2] + tmp[k / 2]) / 2.0;
        else return tmp[k / 2];
    }

//     3.
//    public double findMedianSortedArrays_3(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//        int left = (n + m + 1) / 2;
//        int right = (n + m + 2) / 2;
//        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
//        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left)
//                + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
//    }
//
//    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//        int len1 = end1 - start1 + 1;
//        int len2 = end2 - start2 + 1;
//        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
//        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
//        if (len1 == 0) return nums2[start2 + k - 1];
//
//        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
//
//        //为了防止数组长度小于 k/2,每次比较都会从当前数组所生长度和k/2作比较，取其中的小的(如果取大的，数组就会越界)
//        //然后素组如果len1小于k / 2，表示数组经过下一次遍历就会到末尾，然后后面就会在那个剩余的数组中寻找中位数
//        int i = start1 + Math.min(len1, k / 2) - 1;
//        int j = start2 + Math.min(len2, k / 2) - 1;
//
//        //如果nums1[i] > nums2[j]，表示nums2数组中包含j索引，之前的元素，逻辑上全部淘汰，即下次从J+1开始。
//        //而k则变为k - (j - start2 + 1)，即减去逻辑上排出的元素的个数(要加1，因为索引相减，相对于实际排除的时要少一个的)
//        if (nums1[i] > nums2[j]) {
//            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
//        }
//        else {
//            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
//        }
//    }
}
