package com.github.fedeoasi.sorting;

public class ComparisonCountingSort {
    public static int[] sort(int[] a) {
        int[] s = new int[a.length];
        int[] count = new int[a.length];
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if(a[i] < a[j]) {
                    count[j]++;
                } else {
                    count[i]++;
                }
            }
        }
        for(int i = 0; i < s.length; i++) {
            s[count[i]] = a[i];
        }
        return s;
    }
}
