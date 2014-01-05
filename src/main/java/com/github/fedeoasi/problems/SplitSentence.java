package com.github.fedeoasi.problems;

import java.util.*;

class SplitSentenceScala {
    final static Set<String> dictionary = new HashSet<>(Arrays.asList(
            "the", "this", "hello", "sentence", "separate", "separated", "is"
    ));

    public static boolean canSplit(String sentence) {
        return canSplit(sentence, 0);
    }

    private static boolean canSplit(String sentence, int start){
        int length = sentence.length();
        if(start >= length) {
            return true;
        }
        List<Integer> wordEnds = new LinkedList<>();
        for(int end = start; end < length; end++) {
            String s = sentence.substring(start, end + 1);
            if(dictionary.contains(s)) {
                wordEnds.add(end);
            }
        }
        for(Integer end: wordEnds) {
            if(canSplit(sentence, end + 1)) {
                return true;
            }
        }
        return false;
    }
}