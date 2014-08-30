package com.github.fedeoasi.strings;


public class StringSort {
    static final int CHAR_SET_SIZE = 65536;

    public static String sort(String string) {
        if(string.length() < 2) {
            return string;
        }
        int[] counts = new int[CHAR_SET_SIZE];
        for(int i = 0; i < string.length(); i++) {
            counts[string.charAt(i)]++;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < CHAR_SET_SIZE; i++) {
            int count = counts[i];
            for(int j = 0; j < count; j++) {
                sb.append((char) (i));
            }
        }
        return sb.toString();
    }
}
