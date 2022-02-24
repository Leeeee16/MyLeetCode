package com.algorithm.BinaryTree.basic.LeetCode199;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    // 按照深度优先遍历，从右开始遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        dfs(root,0,res);
        return res;
    }

    private void dfs(TreeNode node, int level, List<Integer> res) {
        if(node == null) {
            return;
        }
        if(res.size() == level) {
            res.add(node.val);
        }

        // 交换下面两行，就是二叉树的左视图
        dfs(node.right, level +1 ,res);
        dfs(node.left, level +1 ,res);
    }
}
