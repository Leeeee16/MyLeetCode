package com.algorithm.binarySearch;

/**
 * @author: lqy
 * @create: 2020/10/19
 * @description: sqrtx
 * 求x的平方根
 */
public class sqrtx {
    public static double sqrt_x(double x) {
        double eps = 1E-8;
        double l = 0, r = Math.max(1, x);
        while (r - l > eps) {
            double mid = l + (r - l) / 2;
            if (mid * mid >= x) r = mid;
            else l = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        double x = 0.01;
        double res = sqrt_x(x);
        System.out.printf("%.6f", res);
    }
}
