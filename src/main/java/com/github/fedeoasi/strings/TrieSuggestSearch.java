package com.github.fedeoasi.strings;

import java.util.List;

public class TrieSuggestSearch implements SuggestSearch {
    Trie trie;

    public TrieSuggestSearch() {
        trie = new Trie();
    }

    @Override
    public List<String> suggest(String search) {
        return trie.search(search);
    }

    @Override
    public void loadDictionary(List<String> dictionary) {
        for(String s: dictionary) {
            System.out.println(s);
            trie.addString(s);
        }
    }
}
