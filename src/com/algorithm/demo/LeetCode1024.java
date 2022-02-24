package com.algorithm.demo;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode1024 {

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() { // 按第一个值升序，第二个值降序
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int count = 0; // 统计碎片数
        int len = clips.length;
        int[] res = new int[2];
        for (int i = 0; i < len; i++) {
            if (clips[i][0] > res[1] && res[1] < T) { // 当前区间左 > 结果数组中最后区间的终止位置
                return -1;  // 不能拼成完整片段
            }
            // 贪心
            int[] tmp_max = clips[i];
            int j = i;
            // 找到满足：左值 <= res[1] 并且 右值最大的 区间tmp_max
            while (j < len && clips[j][0] <= res[1]) {
                if (clips[j][1] >= tmp_max[1]) {
                    tmp_max = clips[j];
                }
                j++;
            }
            i = j - 1;

            res[1] = Math.max(tmp_max[1], res[1]);
            if(clips[i][0] == 0) count = 1;
            else {
                count++;
            }
            if (res[1] >= T) { // 判断是否完成
                return count;
            }
        }
        return -1;
    }

//    public int videoStitching(int[][] clips, int T) {
//        int[] max_n = new int[T];
//        int last = 0, ret = 0, pre = 0;
//        for (int[] clip : clips) {
//            if (clip[0] < T) {
//                max_n[clip[0]] = Math.max(max_n[clip[0]], clip[1]);
//            }
//        }
//        for (int i = 0; i < T; i++) {
//            last = Math.max(last, max_n[i]);
//            if (i == last) {
//                return -1;
//            }
//            if (i == pre) {
//                ret++;
//                pre = last;
//            }
//        }
//        return ret;
//    }

    public static void main(String[] args) {
        LeetCode1024 lc = new LeetCode1024();
//        int[][] nums = {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7},
//                {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        // int T = 9;
        int T = 15;
        int[][] nums = {{16, 18}, {16, 20}, {3, 13}, {1, 18}, {0, 8}, {5, 6}, {13, 17}, {3, 17}, {5, 6}};

        int res = lc.videoStitching(nums, T);
        System.out.println(res);
    }
}
