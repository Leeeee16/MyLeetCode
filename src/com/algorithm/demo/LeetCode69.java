package com.algorithm.demo;

public class LeetCode69 {
    public static double mySqrt(int x) {
        double l = 0, r = (double)Math.max(1, x);
        while(r - l > 1E-6) {
            double mid = l + (r - l) / 2;
            if(mid  >= x / mid) r = mid;
            else l = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        int x = 8;

        System.out.println(mySqrt(x));
    }
}
