package com.algorithm.jianzhi.jianzhi14_1;

/**
 * @Description: 通过数学证明，分为尽量多的长度为3的小段后乘积最大
 * @author: lqy
 * @date: 2021/04/25/ 10:11
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        if (b == 2) {
            return (int)Math.pow(3, a) * 2;
        }
        return (int)Math.pow(3, a);
    }
}
