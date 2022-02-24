package com.algorithm.arr.LeetCode119;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }

    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        List<Integer> ans = new ArrayList<>();
        ans = s3.getRow(6);
        System.out.println(ans);
    }
}
