package com.algorithm.honor.test01;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int dfs(int[] nums, int i, int times, int request) {
        if (i < 0) {
            return 0;
        }
        // 如果当前层满足需要的个数，返回次数
        if (nums[i] >= request) {
            return times;
        }
        // 需要几个下层数字
        request -= nums[i];
        // 算的其实是合成当层剩余的，需要的次数
        times += request;
        return dfs(nums, i - 1, times, 2 * request);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] nums = new int[10];
            for (int j = 0; j < 10; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(dfs(nums, 9, 1, 2));
//            System.out.println(Arrays.toString(nums));
        }
    }
}
