package com.algorithm.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:
 * @create: 2020/10/22
 * @description: LeetCode763
 */
public class LeetCode763 {

    public List<Integer> PartitionLabels(String s) {
        int length = s.length();
        List<Integer> res = new ArrayList<>();
        if (length == 0) {
            return res;
        }
        int st = 0, ed = 0;
        while (st < length) {
            char cur = s.charAt(st); // 当前字母
            st = s.indexOf(cur);
            ed = s.lastIndexOf(cur); // 当前字母最后出现的下标
            for (int j = st + 1; j < ed; j++) {
                char ch_next = s.charAt(j); // 下一个字母
                ed = Math.max(ed, s.lastIndexOf(ch_next));
            }
            res.add(ed - st + 1);
            st = ed + 1;
            if (st == length) {
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LeetCode763 lc = new LeetCode763();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = new ArrayList<>();
        list = lc.PartitionLabels(s);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
