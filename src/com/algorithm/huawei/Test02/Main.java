package com.algorithm.huawei.Test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/12/ 18:31
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 服务总数
        int n = Integer.parseInt(br.readLine());
        // 指定启动服务的编号
        int m = Integer.parseInt(br.readLine());
        // 记录前置服务
        boolean[][] matrix = new boolean[n][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], true);
        }

        // 记录还剩前置服务的个数
        Map<Integer, Integer> map = new HashMap<>();
        // 记录无前置服务的编号
        List<Integer> starts = new ArrayList<>();
        int j = -1;
        String[] str;
        for (int k = 0; k < n; k++) {
            str = br.readLine().split(",");
            j = Integer.parseInt(str[0]);
            if (j == 0) {
                starts.add(k);
                continue;
            }
            System.out.println(Arrays.toString(str));

            j = Integer.parseInt(str[0]);
            map.put(k, j);
            for (int i = 0; i < j; i++) {
                // 前置服务
                int t = Integer.parseInt(str[i + 1]);
                // 表示k是t的前缀
                matrix[t][k] = false;
            }
        }
        // 从starts开始
        if (starts.size() == 0) {
            System.out.println(-1);
            return;
        }
        for (int s = 0; s < starts.size(); s++) {
            // 当前启动的服务
            int x = starts.get(s);
            for (int r = 0; r < n; r++) {
                if (!matrix[x][r]) {
                    matrix[x][r] = true;
                    map.put(r, map.get(r) - 1);
                    if (map.get(r) == 0) {
                        if (r == m) {
                            starts.sort(Comparator.comparingInt(a -> a));
                            System.out.println(starts.toString());
                            return;
                        }
                        starts.add(r);
                    }
                }
            }
        }
    }
}
