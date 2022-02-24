package com.algorithm.UnionFind;

public interface IUnionFind {
    // 并发集的版本名称
    String versionName();

    // p (0 到 N - 1)所在的分量的标识符
    int find(int p);

    // 判断 p 和 q 是否存存在于同一分量重
    boolean isConnection(int p, int q);

    // 在 p 和 q 之间添加一条链接
    void union(int p, int q);

    int getCount();

}
