package com.algorithm.honor.test02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = new String[n];
        Map<String, Integer> map = new HashMap<>();
        boolean isOK = false;
        int tmpSum = 0;
        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine();
            // 保存每个表达式左右
            String[] curStrs = strs[i].split("=");
            // 去除头尾空格
            for (int j = 0; j < curStrs.length; j++){
                curStrs[j] = curStrs[j].trim();
                // 如果有加号
                if (curStrs[j].contains("+")) {
                    // 每个加数
                    String[] tmp = curStrs[j].split("\\+");
                    for (int k = 0; k < tmp.length; k++) {
                        tmp[k] = tmp[k].trim();
                    }
                    System.out.println(Arrays.toString(tmp));
                }

//                System.out.println(curStrs[j]);

            }
//
        }



    }
}
