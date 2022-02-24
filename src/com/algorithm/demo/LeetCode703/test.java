package com.algorithm.demo.LeetCode703;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(-4);
        list.sort(Integer::compareTo);
        System.out.println(list);
    }
}
