package com.github.fedeoasi.combinatorics;

import java.util.ArrayList;
import java.util.Collection;

public class BitMaskedSubsetEnumerator implements SubsetEnumerator {
    @Override
    public Collection<String> enumerateSubsets(String s) {
        Collection<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            return result;
        }
        int allMasks = 1 << s.length();
        for (int i = 1; i < allMasks; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, flag = 1; j < s.length(); j++, flag <<= 1) {
                if ((i & flag) > 0) {
                    sb.append(s.charAt(j));
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}
