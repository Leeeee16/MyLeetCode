package com.algorithm.meituan.Test03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/11/ 9:13
 */
public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int num = sc.nextInt();
        int n = 5;
        int num = 1;
//        System.out.println(num);
        int[] bb = new int[n];
        int i = 0;
        while (num != 0) {
            bb[i] = num % 2;
            i++;
            num = num / 2;
        }
        int num_0 = 0;
        int num_1 = 0;
        for (int b : bb) {
            if (b == 1) {
                num_1++;
            } else {
                num_0++;
            }
        }
        


    }

}
