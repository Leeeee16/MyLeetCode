package com.algorithm.BinaryTree.advance.LeetCode437;

import java.util.HashMap;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        // 用HashMap记录前缀和
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    private int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        // 查看 前缀和 = currSum - target 的数量
        int res = preSum.getOrDefault(currSum - target, 0);
        // 更新前缀和，前缀和为 currSum 的 value + 1
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        // 递归左右子树
        res += helper(root.left, currSum, target, preSum)
                + helper(root.right, currSum, target, preSum);
        // 还原 前缀和， 恢复状态
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}
