package com.algorithm.jianzhi.jianzhi39;

/**
 * @Description: TODO
 * @author: lqy
 * @date: 2021/05/08/ 15:40
 */
public class Solution {
    // 摩尔投票
    // 这里的众数，表示个数大于一半的数
    // 通过抵消的思想，解决
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int votes = 0;
        int res = 0;
        for (int num : nums) {
            if (votes == 0) {
                res = num;
            }
            votes += num == res ? 1 : -1;
        }
        // 检验res是否为众数
        int cnt = 0;
        for (int num : nums) {
            cnt += num == res ? 1 : 0;
        }
        return cnt > len / 2 ? res : -1;

    }
}
