package com.algorithm.baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/03/30/ 18:36
 */
public class Solution02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int p = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }

        Arrays.sort(nums);
        long up = 0;
        long fan = 0;
        long res = 0;
        if (p >= 50) {
            // 一大一小
            for (int i = 0; i < n; i++) {
                up += nums[n + i];
                fan += nums[i];
            }
        } else {
            // 两个一组
            for (int i = 0; i < 2 * n; i++) {
                if (i % 2 == 0) {
                    fan += nums[i];
                } else {
                    up += nums[i];
                }
            }
        }
        res = p * up + (100 - p) * fan;
        if (res % 100 == 0) {
            System.out.println(res / 100);
        } else {
            System.out.println(res + "%");
        }
        return;
    }
}
