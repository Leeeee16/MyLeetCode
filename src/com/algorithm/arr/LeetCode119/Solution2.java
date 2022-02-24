package com.algorithm.arr.LeetCode119;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        List<Integer> ans = new ArrayList<>();
        ans = s2.getRow(3);
        System.out.println(ans);
    }
}
