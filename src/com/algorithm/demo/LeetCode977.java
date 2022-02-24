package com.algorithm.demo;

/**
 * @author: lqy
 * @create: 2020/10/16
 * @description: LeetCode977
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
  */
public class LeetCode977 {
    public static void main(String[] args) {
        int[] A = {-4, -1, 0, 3, 10};
        int[] res = sortedSquares(A);
        System.out.println(res);
    }

     //直接插入排序
    /*public int[] sortedSquares(int[] A) {
        int length = A.length;
        int res[] = new int[length];
        if(length == 0) return null;
        res[0] = A[0] * A[0];
        int j;
        for(int i = 1; i < A.length; i++) {
            int tmp = A[i] * A[i];
            for(j = i - 1; j >= 0; j--) {
                if(tmp < res[j])    res[j + 1] = res[j];
                else break;
            }
            res[j + 1] = tmp;
        }
        return res;
    }
*/

    // 二分查找正负数分界点
    public static int bsearch(int[] A, int l, int r) {
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(A[mid] < 0) l = mid;
            else r = mid -1;
        }
        return l;
    }

    public static int[] sortedSquares(int[] A) {
        int length = A.length;
        if(length == 0) return null;
        int pivot = bsearch(A,0, length - 1);

        for(int i = 0; i < length; i ++)    A[i] *= A[i];
        // 归并正负两部分
        int j = pivot + 1, i = 0;
        int[] res = new int[length];
        while(pivot >= 0 && j <= length - 1) {
            if(A[pivot] <= A[j]) res[i ++ ] = A[pivot -- ];
            else res[i++] = A[j ++ ];
        }
        while(pivot >= 0) res[i ++ ] = A[pivot --];
        while(i <= length - 1) res[i ++ ] = A[j ++];

        return res;
    }
}
