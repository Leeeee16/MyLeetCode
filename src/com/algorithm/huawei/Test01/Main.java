package com.algorithm.huawei.Test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/12/ 18:30
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(",");
        int i = Integer.parseInt(str[0]);
        double x = Double.parseDouble(str[1]);
        System.out.println(i + " " + x);
    }
}
