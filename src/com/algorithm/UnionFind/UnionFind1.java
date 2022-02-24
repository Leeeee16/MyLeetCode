package com.algorithm.UnionFind;

public class UnionFind1 implements IUnionFind {

    private int[] parent; // 第 i 个元素存放它的父元素的索引

    private int count; // 连通分量的数量

    public UnionFind1(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    @Override
    public String versionName() {
        return "基于路径压缩的非递归方法";
    }

    @Override
    public int find(int p) {
        while( p != parent[p]) {
            // 两部一跳，完成路径压缩
            parent[p] = parent[parent[p]];
        }
        return p;
    }

    @Override
    public boolean isConnection(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        return pRoot == qRoot;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) {
            return;
        }
        parent[pRoot] = qRoot;
        count--;
    }

    @Override
    public int getCount() {
        return this.count;
    }
}
