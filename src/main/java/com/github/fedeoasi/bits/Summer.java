package com.github.fedeoasi.bits;

public class Summer {
    public static int xor(int[] a) {
        if(a.length == 0) {
            throw new IllegalArgumentException("At least one element is required");
        }
        int result = a[0];
        for(int i = 1; i < a.length; i++) {
            result = result ^ a[i];
        }
        return result;
    }
}
