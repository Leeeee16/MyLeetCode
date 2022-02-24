package com.algorithm.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing795 {

    public static void main(String[] args) throws IOException {
        int N = 100010;
        int[] a = new int[N];
        int[] s = new int[N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(str[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
        }
        while (m-- > 0) {
            str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);

            System.out.println(s[r] - s[l - 1]);
        }

        br.close();
    }
}
