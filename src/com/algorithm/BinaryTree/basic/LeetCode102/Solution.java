package com.algorithm.BinaryTree.basic.LeetCode102;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> nodes = new ArrayList<>();
            int curSize = queue.size();
            while (curSize > 0) {
                TreeNode cur = queue.poll();
                nodes.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null) {
                    queue.add(cur.right);
                }
                curSize--;
            }
            res.add(nodes);
        }
        return res;
    }
}
