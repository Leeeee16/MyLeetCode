package com.algorithm.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class LeetCode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = Math.abs(arr[i] - x);
        }
        int left = 0, right = len - 1;
        while (right - left + 1 > k) {
            if (tmp[right] >= tmp[left]) {
                right--;
            } else {
                left++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(arr[left + i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode658 lc = new LeetCode658();
        int[] arr = new int[]{1, 1, 1, 10, 10, 10};
        int k = 1, x = 9;
        List<Integer> ans;
        ans = lc.findClosestElements(arr, k, x);
        System.out.println(ans.toString());
    }
}
