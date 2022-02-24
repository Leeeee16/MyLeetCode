package com.algorithm.Trie;

public class MyTrie {

    private Node root;

    private class Node {
        private Node[] dict;
        // 是否是一个单词的结束
        private boolean isWord;

        // 假设输入为小写字母
        public Node() {
            dict = new Node[26];
            this.isWord = false;
        }
    }

    /** Initialize your data structure here. */
    public MyTrie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len = word.length();
        Node curNode = root;
        for (int i = 0; i < len; i++) {
            char curChar = word.charAt(i);
            Node next = curNode.dict[curChar - 'a'];
            // 如果不存在，就新建一个节点
            if (next == null) {
                curNode.dict[curChar - 'a'] = new Node();
            }
            curNode = curNode.dict[curChar - 'a'];
        }
        // 将当前节点设置为结尾节点
        if (!curNode.isWord) {
            curNode.isWord = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int len = word.length();
        Node curNode = root;

        for (int i = 0; i < len; i++) {
            char curC = word.charAt(i);
            Node next = curNode.dict[curC - 'a'];
            if (next == null) {
                return false;
            } else {
                curNode = next;
            }
        }
        return curNode.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        Node curNode = root;

        for (int i = 0; i < len; i++) {
            char curC = prefix.charAt(i);
            Node next = curNode.dict[curC - 'a'];
            if (next == null) {
                return false;
            } else {
                curNode = next;
            }
        }
        return true;
    }
}
