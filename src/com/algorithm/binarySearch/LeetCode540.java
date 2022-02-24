package com.algorithm.binarySearch;

/**
 * @author: lqy
 * @create: 2020/10/19
 * @description: LeetCode540
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 */
public class LeetCode540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        return bsearch(nums, 0, nums.length - 1);
    }

    public int bsearch(int[] nums, int l, int r) {
        int len = nums.length;
        if(nums[0] != nums[1]) return nums[0];
        if(nums[len - 1] != nums[len - 2]) return nums[len - 1];
        while (l < r) {
            int mid = l + r >> 1;

            if(mid > 0 && mid < len - 1) {
                if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];

                if ((mid % 2 == 0 && nums[mid - 1] == nums[mid]) || (mid % 2 == 1 && nums[mid] != nums[mid - 1])) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {7,7,11,11,99,8,8};
        LeetCode540 lc = new LeetCode540();
        int res = lc.singleNonDuplicate(nums);
        System.out.println(res);
    }
}
