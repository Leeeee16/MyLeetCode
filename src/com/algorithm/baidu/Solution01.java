package com.algorithm.baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/03/30/ 18:36
 */
public class Solution01 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 2) {
            System.out.println(0);
            return;
        }
        String[] s = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        // 用hashMap保存每个数能跳到的最远坐标
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 如果之前没有出现，需要的步数为 dp[i - 1] + 1
            if (!hashMap.containsKey(nums[i])) {
                dp[i] = dp[i - 1] + 1;
                hashMap.put(nums[i], dp[i]);
            } else {
                dp[i] = hashMap.get(nums[i]);
            }
        }
        System.out.println(dp[n - 1]);
    }
}
