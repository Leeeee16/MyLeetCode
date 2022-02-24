package com.algorithm.jianzhi.jianzhi38;

import java.util.*;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/06/ 10:30
 */
public class Solution {

    List<String> list = new ArrayList<>();
    char[] c;


    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return list.toArray(new String[0]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            list.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(c, i, x);
            dfs(x + 1);
            swap(c, i, x);
        }
    }

    private void swap(char[] c, int i, int x) {
        char tmp = c[i];
        c[i] = c[x];
        c[x] = tmp;
    }

    public static void main(String[] args) {
        Solution s38 = new Solution();
        String s = "abc";
        String[] res = s38.permutation(s);
        System.out.println(Arrays.toString(res));
    }
}
