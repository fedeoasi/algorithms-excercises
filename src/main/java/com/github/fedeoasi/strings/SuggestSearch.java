package com.github.fedeoasi.strings;

import java.util.List;

public interface SuggestSearch {
    void loadDictionary(List<String> dictionary);
    List<String> suggest(String search);
}
