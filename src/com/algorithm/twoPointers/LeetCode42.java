package com.algorithm.twoPointers;

public class LeetCode42 {
    // 1. 暴搜
    public int trap_1(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            int left = i - 1, right = i + 1;
            int l_max = 0, r_max = 0;
            int l_highest = 0, r_highest = 0;
            while (left >= 0) {
                if (height[left] >= l_max) {
                    l_highest = left;
                    l_max = height[left];
                }
                left--;
            }
            while (right < len) {
                if (height[right] >= r_max) {
                    r_highest = right;
                    r_max = height[right];
                }
                right++;
            }
            if (l_max > height[i] && r_max > height[i]) {
                ans += Math.min(l_max, r_max) - height[i];
            }
        }
        return ans;
    }

    // 2.
    public int trap_2(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }

        // leftHighest[i]：区间[0, i-1]中的最大值
        int[] leftHighest = new int[len];
        for (int i = 1; i < len - 1; i++) {
            leftHighest[i] = Math.max(height[i - 1], leftHighest[i - 1]);
        }

        int[] rightHighest = new int[len];
        for (int i = len - 2; i > 0; i--) {
            rightHighest[i] = Math.max(height[i + 1], rightHighest[i + 1]);
        }

        int ans = 0;
        for (int i = 1; i < len - 1; i++) {
            int minHeight = Math.min(leftHighest[i], rightHighest[i]);
            if (minHeight > height[i]) {
                ans += minHeight - height[i];
            }
        }
        return ans;
    }

    // 3. 双指针(指针对撞)
    public int trap_3(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int ans = 0;
        int leftHighest = height[0];
        int rightHighest = height[len - 1];
        int left = 1, right = len - 2;
        while (left <= right) {
            if (leftHighest <= rightHighest) {
                if(leftHighest > height[left]) {
                    ans += leftHighest - height[left];
                }
                leftHighest = Math.max(leftHighest, height[left]);
                left++;
            } else {
                if(rightHighest > height[right]) {
                    ans += rightHighest - height[right];
                }
                rightHighest = Math.max(rightHighest, height[right]);
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode42 lc = new LeetCode42();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = lc.trap_3(height);
        System.out.println(ans);
    }
}
