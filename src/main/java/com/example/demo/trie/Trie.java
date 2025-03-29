package com.example.demo.trie;

public class Trie {

    static final int ALPHABET_SIZE = 26;

    public static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        public boolean isEndOfWord;
        public String label;
        public String detail; // Add detail field

        public TrieNode() {
            isEndOfWord = false;
            label = "";
            detail = "";
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    static {
        root = new TrieNode();
    }

    public static void insert(String key, String label, String detail) {
        int length = key.length();
        TrieNode pCrawl = root;

        for (int level = 0; level < length; level++) {
            char ch = key.charAt(level);
            if (ch < 'a' || ch > 'z') {
                continue;
            }
            int index = ch - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
        pCrawl.label = label;
        pCrawl.detail = detail;
    }

    public static TrieNode search(String key) {
        TrieNode pCrawl = root;
        for (int level = 0; level < key.length(); level++) {
            char ch = key.charAt(level);
            if (ch < 'a' || ch > 'z') {
                continue;
            }
            int index = ch - 'a';
            if (pCrawl.children[index] == null) {
                return null;
            }
            pCrawl = pCrawl.children[index];
        }
        return pCrawl.isEndOfWord ? pCrawl : null;
    }
}
