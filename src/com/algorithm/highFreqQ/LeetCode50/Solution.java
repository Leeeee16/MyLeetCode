package com.algorithm.highFreqQ.LeetCode50;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/03/ 17:03
 */
public class Solution {
    public double myPow(double x, int n) {
        if (x == 0 || x == 1.0 || n == 1) {
            return x;
        }
        long pow = n;
        if (n < 0) {
            x = 1 / x;
            pow = -pow;
        }
        double ans = 1.0;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                ans *= x;
            }
            x *= x;
            pow = pow >> 1;
        }
        return ans;
    }
}
