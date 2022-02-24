package com.algorithm.arr.LeetCode697;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        int maxNum = 0;
        // 存起始坐标
        Map<Integer, Integer> startIdx = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!startIdx.containsKey(nums[i])) {
                startIdx.put(nums[i], i);
            }
            if (nums[i] > maxNum) {
                maxNum = nums[i];
            }
        }
        int N = maxNum + 1;
        int[] freq = new int[N];
        int maxFreq = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            freq[nums[i]]++;
            if (freq[nums[i]] > maxFreq) {
                maxFreq = freq[nums[i]];
                ans = i - startIdx.get(nums[i]) + 1;
            } else if (freq[nums[i]] == maxFreq) {
                ans = Math.min(ans, i - startIdx.get(nums[i]) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,1,4,2};
        Solution solution = new Solution();
        int ans = solution.findShortestSubArray(nums);
        System.out.println(ans);
    }
}
