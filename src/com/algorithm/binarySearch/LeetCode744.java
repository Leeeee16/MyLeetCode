package com.algorithm.binarySearch;

/**
 * @author: lqy
 * @create: 2020/10/19
 * @description: LeetCode744
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target
 * 请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 */
public class LeetCode744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        if(target >= letters[r] || target < letters[0]) return letters[0];
        while (l < r) {
            int mid = l + r >> 1;
            if (letters[mid] > target) r = mid;
            else l = mid + 1;
        }
        return letters[l];
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'c', 'f', 'j'};
        char[] targets = new char[]{'a', 'c', 'd', 'g', 'j', 'k'};
        for (int i = 0; i < targets.length; i++) {
            System.out.print(nextGreatestLetter(letters, targets[i]) + " "); // c f f j c c
        }
    }
}
