package com.algorithm.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lqy
 * @create: 2020/10/14
 * @description: Leetcode1002
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * https://leetcode-cn.com/problems/find-common-characters/
 * 你可以按任意顺序返回答案。
 */
public class Leetcode1002 {
    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        List<String> res = new ArrayList<>();
        res = commonChars(A);
//        System.out.println(res);
        System.out.println(1 + 'a');
        System.out.println((char)(2 + 'a'));
        System.out.println(String.valueOf((char)(2 + 'a')));
    }

    public static List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] res = new int[26];
        for(char c : A[0].toCharArray()) {
            res[c - 'a'] ++;
        }
        for(int i = 1; i < A.length; i ++) {
            int[] tmp = new int[26];
            for(char c : A[i].toCharArray()) {
                tmp[c - 'a'] ++;
            }
            for(int j = 0; j < 26; j ++) {
                res[j] = Math.min(res[j], tmp[j]);
            }
        }
        for(int i = 0; i < res.length; i ++) {
            if(res[i] > 0) {
                for(int j = 0; j < res[i]; j ++) {
                    list.add(String.valueOf((char)('a' + i)));
                }
            }
        }
        return list;
    }
}
