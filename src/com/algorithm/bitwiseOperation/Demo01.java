package com.algorithm.bitwiseOperation;

/**
 * @author: lqy
 * @create: 2020/11/8
 * @description: n的二进制表示中第K位是几：n >> k & 1
 */
public class Demo01 {
    public static void main(String[] args) {
        int n = 10;
        for (int k = 3; k >= 0; k--) {
            System.out.print(n >> k & 1); // 1010
        }
    }
}
