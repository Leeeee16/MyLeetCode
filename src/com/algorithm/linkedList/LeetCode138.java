package com.algorithm.linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LeetCode138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    HashMap<Node, Node> visited = new HashMap<Node, Node>();

    // 将链表看成图，使用递归
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 如果当前节点已经copy过了，直接返回
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }
        // 创建新的copy节点
        Node node = new Node(head.val);
        // 添加到hashMap中
        visitedHash.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    // 使用迭代思路
    public Node getClonedNode(Node node) {
        if (node != null) {
            // 如果当前节点没有访问过，则创建新的节点；否则直接返回
            if (!this.visited.containsKey(node)) {
                this.visited.put(node, new Node(node.val));
            }
            return this.visited.get(node);
        }
        return null;
    }

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;
        //创建新的头结点
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }

}
