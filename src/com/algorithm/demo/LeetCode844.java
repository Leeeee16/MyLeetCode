package com.algorithm.demo;

/**
 * @author: lqy
 * @create: 2020/10/19
 * @description: LeetCode844
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
  */
public class LeetCode844 {
    public static void main(String[] args) {
        LeetCode844 lc = new LeetCode844();
        String S = new String("ab#c");
        String T = new String("ad#c");
        boolean res = lc.backspaceCompare(S, T);
        System.out.println(res);
    }

    public boolean backspaceCompare(String S, String T) {
        // 1. 重构字符串
//        return build(S).equals(build(T));
        // 2. 双指针
        int lenS = S.length() - 1, lenT = T.length() - 1;
        int skipS = 0, skipT = 0;
        while(lenS >= 0 || lenT >=0) {
            // 两个while分别得到两个字符串下一个有效的字符下标
            while(lenS >= 0) {
                if(S.charAt(lenS) == '#') {
                    skipS++;
                    lenS--;
                }else if(skipS > 0) {
                    skipS--;
                    lenS--;
                }else {
                    break;
                }
            }
            while(lenT >= 0) {
                if(T.charAt(lenT) == '#') {
                    skipT++;
                    lenT--;
                }else if(skipT > 0) {
                    skipT--;
                    lenT--;
                }else {
                    break;
                }
            }
            // 判断两个字符是否相同，不同返回false，相同 游标继续向前遍历
            if(lenS >= 0 && lenT >= 0) {
                if(S.charAt(lenS) != T.charAt(lenT)) return false;
            }else {
                if(lenS >= 0 || lenT >= 0) return false;
            }
            lenS--;
            lenT--;
        }
        return true;
    }

    public String build(String str) {
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if(ch != '#') sb.append(ch);
            else {
                if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
