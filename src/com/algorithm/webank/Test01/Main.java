package com.algorithm.webank.Test01;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/04/06/ 18:02
 */
import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            // 特判
            if (n == 0) {
                continue;
            }
            int[] nums = new int[n];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(str[i]);
            }
            // System.out.println(Arrays.toString(nums));
            Main m = new Main();
            String ans = m.help(nums);
            System.out.println(ans);
        }
    }

    private String help(int[] nums) {
        int len = nums.length;
        if (len == 1 && nums[0] == 0) {
            return "0";
        }
        int sum = 0;
        boolean hasZero = false;
        boolean hasNoZero = false;
        // 判断是否符合条件：能被30整除
        for (int num : nums) {
            if (num == 0) {
                hasZero = true;
            }
            if (num != 0) {
                hasNoZero = true;
            }
            sum += num;
        }
        if (sum % 3 != 0 || !hasZero || !hasNoZero) {
            return "-1";
        }
        // 求最大
        // 排序
        Arrays.sort(nums);
        long ans = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}
