package com.github.fedeoasi.strings;

public class StringRotation {
    public static boolean isRotatedBy(String input, String source, int slots) {
        int len = source.length();
        if(input.length() != len || len == 0) {
            return false;
        }
        int actualSlots = slots % len;
        return testRotation(input, source, len, actualSlots) ||
               testRotation(input, source, len, len - actualSlots);
    }

    private static boolean testRotation(String input, String source, int len, int shift) {
        for(int i = 0; i < len; i++) {
            if(source.charAt(i) != input.charAt((i + shift) % len)) {
                return false;
            }
        }
        return true;
    }
}
