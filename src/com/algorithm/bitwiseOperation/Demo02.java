package com.algorithm.bitwiseOperation;

/**
 * @author: lqy
 * @create: 2020/11/8
 * @description: lowbit(x)：返回x的最后一位1
 * 比如：x = 1010 , lowbit(x) = 10
 * x = 1010000, lowbit(x) = 10000
 * lowbit(x)：x & -x = x & (~x + 1)
 * -x：x的补码，x取反+1
 */
public class Demo02 {
    public static int lowbit(int x) {
        return x & -x;
    }

    public static void main(String[] args) {
        int x = 15;
        int res = 0;
        while (x != 0) {
            x -= lowbit(x);
            res++;
        }
        System.out.println(res); // 4
    }
}
