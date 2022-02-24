package com.algorithm.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing789 {
    public static void main(String[] args) throws IOException {
        int N = 100010;
        int[] q = new int[N];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);   // 数组元素个数
        int m = Integer.parseInt(str[1]);   // 询问数组元素
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {   // 读入数组元素
            q[i] = Integer.parseInt(str[i]);
        }

        while (m-- > 0) {
            int x = Integer.parseInt(br.readLine());    // 询问元素

            int l = 0, r = n - 1;
            // 找左边界，即check
            while (l < r) {
                int mid = l + r >> 1;
                if (q[mid] >= x) r = mid;
                else l = mid + 1;
            }
            // 数组不包含该元素，返回 -1 -1
            if (q[l] != x) System.out.println("-1 -1");
            // 找右边界
            else {
                System.out.print(l + " ");

                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (q[mid] <= x) l = mid;
                    else r = mid - 1;
                }
                System.out.println(l);
            }
        }
        br.close();
    }
}
