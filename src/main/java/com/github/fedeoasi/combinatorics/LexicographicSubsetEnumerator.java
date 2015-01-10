package com.github.fedeoasi.combinatorics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LexicographicSubsetEnumerator implements SubsetEnumerator {
    @Override
    public Collection<String> enumerateSubsets(String s) {
        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            return result;
        } else if (s.length() == 1) {
            result.add(s);
            return result;
        } else {
            String start = s.substring(0, 1);
            result.add(start);
            Collection<String> subsetsWithoutFirst = enumerateSubsets(s.substring(1));
            for (String inSubset: subsetsWithoutFirst) {
                result.add(start + inSubset);
            }
            for (String inSubset: subsetsWithoutFirst) {
                result.add(inSubset);
            }
            return result;
        }
    }
}
