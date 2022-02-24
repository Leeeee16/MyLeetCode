package com.algorithm.UnionFind.LeetCode765;

// https://liweiwei1419.gitee.io/leetcode-algo/2017/11/01/leetcode-algo/0765-couples-holding-hands/
public class Solution {
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            unionFind.union(row[2 * i] / 2, row[2 * i + 1] / 2);
        }
        return N - unionFind.count;
    }

    private class UnionFind{
        private int[] parent;
        private int count;

        // 初始化并查集
        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // 找x所在树的根节点（所属的集合）
        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        // 合并两个集合
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            count--;
        }
    }
    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3};
        // int[] row = {3, 2, 0, 1};
        Solution solution = new Solution();

        int res = solution.minSwapsCouples(row);
        System.out.println(res);
    }
}

