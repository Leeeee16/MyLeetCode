package com.algorithm.dfs.LeetCode17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    String[] digits2String = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        char[] digitStr = digits.toCharArray();
        combineDigits(sb, digitStr, 0);
        return ans;
    }

    private void combineDigits(StringBuilder sb, char[] digitStr, int k) {
        // 终止条件
        if (k == digitStr.length) {
            ans.add(sb.toString());
            return;
        }
        // 得到当前数字
        int digit = digitStr[k] - '0';
        // 得到当前数字对应的字符数组
        char[] str = digits2String[digit].toCharArray();
        // 遍历字符数组
        for (char c : str) {
            sb.append(c);
            combineDigits(sb, digitStr, k + 1);
            // 回溯
            sb.deleteCharAt(k);
        }
    }
}
