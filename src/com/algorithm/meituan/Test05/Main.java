package com.algorithm.meituan.Test05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/11/ 11:49
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(), sc.nextInt());
        }
        int m = sc.nextInt();
        Map<Integer, Integer> targetMap = new HashMap<>();
        int res = 0;

    }
}
