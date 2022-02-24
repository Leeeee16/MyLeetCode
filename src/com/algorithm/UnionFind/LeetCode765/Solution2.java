package com.algorithm.UnionFind.LeetCode765;

public class Solution2 {
    // 贪心解
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int ans = 0;
        // 记录row中的值的索引
        int[] map = new int[len];
        for (int i = 0; i < len; i++) {
            map[row[i]] = i;
        }
        for (int i = 0; i < len; i += 2) {
            // 通过异或求出的情侣
            int anotherOne = row[i] ^ 1;

            if (row[i + 1] == anotherOne) {
                continue;
            }
            // 如果这对情侣没有牵手
            // 找到情侣，与 i+1 位置互换
            int anotherOneIdx = map[anotherOne];
            // 更新map索引
            map[anotherOne] = i + 1;
            map[row[i + 1]] = anotherOneIdx;
            // row中互换位置
            swap(row, anotherOneIdx, i + 1);
            ans++;
        }
        return ans;
    }

    private void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}
