package com.algorithm.twoPointers.LeetCode424;

class Solution {
    private int[] map = new int[26];
    public int characterReplacement(String s, int k) {
        if (s == null) {
            return 0;
        }
        char[] c = s.toCharArray();
        int left = 0;
        int right = 0;
        // 字母中出现的最多次数
        int charMax = 0;
        for (right = 0; right < c.length; right++) {
            int index = c[right] - 'A';
            map[index]++;
            charMax = Math.max(charMax, map[index]);
            if (right - left + 1 > charMax + k) {
                map[c[left] - 'A']--;
                left++;
            }
        }
        return c.length-left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "ABBB";
        int r = s.characterReplacement(ss, 2);
        System.out.println(r);
    }
}


