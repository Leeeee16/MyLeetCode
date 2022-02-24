package com.algorithm.demo.LeetCode703;

import java.util.*;

class KthLargest {
    List<Integer> list;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
    }

    public int add(int val) {
        list.add(val);
        list.sort((o1, o2) -> o2 - o1);
        System.out.println(list);
        return list.get(k - 1);
    }
}

