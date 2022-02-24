package com.algorithm.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: lqy
 * @create: 2020/10/19
 * @description: ACWing790
 * 数的三次方根
  */
public class ACWing790 {
    static int N = 10000; // 假设数的取值范围
    public static double cubeRoot(double x) {
        double l = -N, r = N;
        double eps = 1E-8;
        while (r - l > eps) {
            double mid = l + (r - l) / 2;
            if (mid * mid * mid >= x) r = mid;
            else l = mid;
        }
        return l;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double x = Double.parseDouble(br.readLine());
        double cube_root = cubeRoot(x);
        System.out.printf("%.6f%n", cube_root);
    }
}
