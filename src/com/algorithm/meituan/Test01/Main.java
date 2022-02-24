import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
        int n = 5;
        int k = 3;
        int[] nums = new int[]{4,5,0,3,3};
        List<Integer> a = new ArrayList<>(n);
        // 记录0的下标
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                a.add(i);
            }
        }

        // 下标
        int res = 0;
        // 期望
        int min = Integer.MAX_VALUE;
        // 计算每个满足的房子的期望
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0 && nums[i] <= k) {
                int cur = 0;
                for (int j = 0; j < a.size(); j++) {
                    cur  = cur + Math.abs(a.get(j) - i);
                }
                if (cur < min) {
                    res = i + 1;
                    min = cur;
                }
            }

        }
        System.out.println(res);
    }
}
