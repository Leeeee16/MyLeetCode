package com.algorithm.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: lqy
 * @create: 2020/10/22
 * @description: AcWing803
 * 给定 n 个区间 [li,ri]，要求合并所有有交集的区间。
 * <p>
 * 注意如果在端点处相交，也算有交集。
 * <p>
 * 输出合并完成后的区间个数。
 * <p>
 * 例如：[1,3]和[2,6]可以合并为一个区间[1,6]。
 * <p>
 * 输入格式
 * 第一行包含整数n。
 * <p>
 * 接下来n行，每行包含两个整数 l 和 r。
 * <p>
 * 输出格式
 * 共一行，包含一个整数，表示合并区间完成后的区间个数。
 */
public class AcWing803 {
    // 返回合并后的区间数
    public static int merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
//        int[][] res = new int[intervals.length][2];
        int count = 0;
        int st = Integer.MIN_VALUE, ed = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (count == 0 || interval[0] > ed) {
                count++;
//                st = interval[0];
                ed = interval[1];
            } else {
                ed = Math.max(ed, interval[1]);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        // 读取输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 读取区间个数
        // 分别读取各个区间
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] ch = br.readLine().split(" ");
            intervals[i][0] = Integer.parseInt(ch[0]);
            intervals[i][1] = Integer.parseInt(ch[1]);
        }
        // 合并区间
        int res = merge(intervals);
        System.out.println(res);
    }
}
