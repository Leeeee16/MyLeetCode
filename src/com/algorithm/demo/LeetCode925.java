package com.algorithm.demo;

public class LeetCode925 {
    public boolean isLongPressedName(String name, String typed) {
        int len_t = typed.length(), len_n = name.length();
        if(len_t == 0 || len_t < len_n) return false;
        int count1 = 0, count2 = 0;
        int i = 0, j = 0;
        while(i < len_n && j < len_t) {
            char tmp = name.charAt(i);
            while(i < len_n && tmp == name.charAt(i)) {
                i++;
                count1++;
            }
            while(j < len_t && typed.charAt(j) == tmp) {
                j++;
                count2++;
            }
            if(count1 <= count2) {
                count1 = 0;
                count2 = 0;
            }else {
                return false;
            }
        }
        if(i != len_n || j != len_t) return false;
        else return true;
    }

    public static void main(String[] args) {
        String name = "chenm";
        String typed = "cchhenmhmm";
        LeetCode925 lc = new LeetCode925();
        boolean re = lc.isLongPressedName(name,typed);
        System.out.println(re);
    }
}
