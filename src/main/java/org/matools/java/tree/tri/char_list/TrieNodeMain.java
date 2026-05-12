package org.matools.java.tree.tri.char_list;

import java.util.HashMap;
import java.util.Map;

class Node {
    Map<Character, Node> children = new HashMap<>();
    boolean isEndOfWord;
}

class Trie {
    private final Node root;
    private int wordCount;

    public Trie() {
        root = new Node();
        wordCount = 0;
    }

    // Insert word into trie
    public void insert(String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new Node());
            current = current.children.get(ch);
        }

        // Only count new unique words
        if (!current.isEndOfWord) {
            current.isEndOfWord = true;
            wordCount++;
        }
    }

    // Search exact word
    public boolean search(String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }

        return current.isEndOfWord;
    }

    // Total words stored
    public int getWordCount() {
        return wordCount;
    }
}

public class TrieNodeMain {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("bat");
        trie.insert("ball");
        trie.insert("apple"); // duplicate, won't increase count
        trie.insert("hello123");
        trie.insert("hi!");

        System.out.println(trie.search("apple"));    // true
        System.out.println(trie.search("hello123")); // true
        System.out.println(trie.search("hi!"));      // true
        System.out.println(trie.search("cat"));      // false

        System.out.println("Total unique words: " + trie.getWordCount()); // 5
    }
}