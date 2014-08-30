package com.github.fedeoasi.strings;

import java.util.LinkedList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public void addString(String s) {
        ensureRoot();

        TrieNode currentSearchNode = root;
        TrieNode previousSearchNode = null;
        int currentIndex = 0;
        while (currentSearchNode != null) {
            previousSearchNode = currentSearchNode;
            currentSearchNode = currentSearchNode.nodeForChar(s.charAt(currentIndex));
            if(currentSearchNode != null) {
                currentIndex++;
            }
        }

        if(currentIndex == s.length()) {
            if(currentSearchNode.string == null) {
                currentSearchNode.string = s;
            }
            return;
        }

        TrieNode mountPoint = previousSearchNode != null ? previousSearchNode : root;

        TrieNode previousNode = null;
        TrieNode firstNewNode = null;
        for (int i = currentIndex; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            TrieNode currentNode = initCurrentNode(currentChar, i == s.length() - 1, s);
            if (i == currentIndex) {
                firstNewNode = currentNode;
            }
            if (previousNode != null) {
                previousNode.addNode(currentNode);
            }
            previousNode = currentNode;
        }
        mountPoint.addNode(firstNewNode);
    }

    private void ensureRoot() {
        if(root == null) {
            root = new TrieNode(null, new LinkedList<TrieNode>());
        }
    }

    private TrieNode initCurrentNode(char currentChar, boolean finalNode, String s) {
        LinkedList<TrieNode> children = new LinkedList<>();
        if (finalNode) {
            return new TrieNode(currentChar, children, s);
        }
        return new TrieNode(currentChar, children);
    }

    public List<String> search(String s) {
        //match prefix and return matching node
        TrieNode currentNode = root;
        int currentIndex = 0;
        while (currentIndex < s.length() && currentNode != null) {
            currentNode = currentNode.nodeForChar(s.charAt(currentIndex));
            currentIndex++;
        }

        //Gather all strings from and after matching node
        LinkedList<String> result = new LinkedList<>();
        if(currentIndex == s.length() && currentNode != null) {
            return searchInternal(currentNode, result);
        }
        return result;
    }

    private List<String> searchInternal(TrieNode node, List<String> result) {
        if (node.string != null) {
            result.add(node.string);
        }
        for (TrieNode c: node.children) {
            searchInternal(c, result);
        }
        return result;
    }

    class TrieNode {
        TrieNode(Character character, List<TrieNode> children, String string) {
            this.character = character;
            this.children = children;
            this.string = string;
        }

        TrieNode(Character character, List<TrieNode> children) {
            this.character = character;
            this.children = children;
        }

        Character character;
        List<TrieNode> children;
        String string;

        void addNode(TrieNode node) {
            children.add(node);
        }

        @Override
        public String toString() {
            return character == null ? "root" : character + "";
        }

        public TrieNode nodeForChar(char character) {
            for(TrieNode node: children) {
                if(node.character == character) {
                    return node;
                }
            }
            return null;
        }
    }
}
