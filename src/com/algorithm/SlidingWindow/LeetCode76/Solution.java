package com.algorithm.SlidingWindow.LeetCode76;


public class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }
        char[] tArray = t.toCharArray();
        int[] tHashMap = new int[128];
        int distance = 0;
        for (char c : tArray) {
            if (tHashMap[c] == 0) {
                distance++;
            }
            tHashMap[c]++;
        }
        int[] sHashMap = new int[128];
        char[] sArray = s.toCharArray();
        int left = 0;
        int right = 0;
        int count = 0;
        int res = Integer.MAX_VALUE;
        String ans = "";
        while (right < sLen) {
            // right右移
            while (right < sLen && count < distance) {
                // 如果 t 中有当前字符，则计数 + 1
                if (tHashMap[sArray[right]] > 0) {
                    sHashMap[sArray[right]]++;
                    // 如果当前字符个数 与 t 中个数相同，count ++
                    if (sHashMap[sArray[right]] == tHashMap[sArray[right]]) {
                        count++;
                    }
                }
//                System.out.println("right:" + right);
                right++;
            }
            if (count < distance) {
                break;
            }
            // left右移
            while (left < right) {
                // 如果当前字符是t中字符，计数 - 1
                if (tHashMap[sArray[left]] > 0) {
                    sHashMap[sArray[left]]--;
                    // 如果当前字符个数 < t中个数，退出循环
                    if (sHashMap[sArray[left]] < tHashMap[sArray[left]]) {
                        count--;
                        break;
                    }
//                    System.out.println("left:" + left);
                }
                left++;
            }
            if (right - left < res) {
                ans = s.substring(left, right);
                res = right - left;
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "bdab";
        String t = "ab";
        String ans = solution.minWindow(s,t);
        System.out.println(ans);

    }
}