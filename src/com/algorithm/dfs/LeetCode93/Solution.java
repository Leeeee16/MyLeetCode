package com.algorithm.dfs.LeetCode93;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/15/ 9:49
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len < 4 || len > 12) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>();
        dfs(s, 0, 4, len, path, res);
        return res;
    }

    private void dfs(String s, int begin, int rest, int len, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (rest == 0) {
                res.add(String.join(".", path));

                return;
            }
        }

        for (int i = begin; i < 3 + begin; i++) {
            if (i >= len) {
                return;
            }

            if (len - i > rest * 3) {
                continue;
            }


            if (judge(s, begin, i)) {
                String cur = s.substring(begin, i + 1);
                path.addLast(cur);
                dfs(s, i + 1, rest - 1, len, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judge(String s, int left, int right) {
        // 开头不为0
        if (left < right && s.charAt(left) == '0') {
            return false;
        }

        // 转成int
        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }

    public static void main(String[] args) {
        String Ip = "25525511135";
        Solution s93 = new Solution();
        List<String> res = new ArrayList<>();
        res = s93.restoreIpAddresses(Ip);
        System.out.println(res.toString());
    }
}
