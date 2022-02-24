package com.algorithm.BinaryTree.Important.LeetCode297;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(node.val).append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        String[] split = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.offer(s);
        }
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String head = queue.poll();
        if (head.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(head));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}
