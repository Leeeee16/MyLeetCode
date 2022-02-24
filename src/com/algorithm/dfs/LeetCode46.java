package com.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

class Solution46 {
    static boolean[] st;
    static int n;
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        List<Integer> path = new ArrayList<>();
        st = new boolean[n];
        dfs(0, nums, path);
        return res;
    }

    public void dfs(int u, int[] nums, List<Integer> path) {
        if(u == n) { // 表示当前情况已经选完，返回路径
            // res.add(path);  错误写法
            /*
            path在所指向的列表，在整个遍历过程中只有一份。
            java的参数传递是值传递；
            对象类型变量在传参过程中，传递的是变量的地址
             */
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!st[i]) {
                path.add(nums[i]);
                st[i] = true;
                dfs(u + 1, nums, path);
                st[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res;
        Solution46 s = new Solution46();
        res = s.permute(nums);
        System.out.println(res);
    }
}

