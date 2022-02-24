package com.algorithm.demo;

class Solution03 {
    boolean check(int x) {
        /**
         * 检查x是否满足某种性质
         */
        return true;
    }

    // bsearch_1和bsearch_2为整数二分模板
    // 区间[l, r]被划分成[l, mid]和[mid + 1, r]时使用
    int bsearch_1(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) r = mid; // check()判断mid是否满足性质
            else l = mid + 1;
        }
        return l;
    }

    // 区间[l, r]被划分成[l, mid - 1]和[mid, r]时使用
    int bsearch_2(int l, int r) {
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    boolean check(double x) {
        // 检查x是否满足某种性质
        return true;
    }
    //浮点数二分模板
    double bsearch_3(double l, double r) {
        double eps = 1E-6; // eps表示精度，取决于题目对精度的要求，一般比要求精度多两位
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if(check(mid)) r = mid;
            else l = mid;
        }
        return l;
    }
}

public class BSearch {
    public static void main(String[] args) {

    }
}
