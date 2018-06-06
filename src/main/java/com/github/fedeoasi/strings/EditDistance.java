package com.github.fedeoasi.strings;

import java.util.Arrays;

public class EditDistance {
    public static int distance(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return Math.max(a.length(), b.length());
        }
        int[][] cost = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            cost[i][0] = i;
        }
        for (int j = 0; j < b.length(); j++) {
            cost[0][j] = j;
        }
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                int ins = (i > 0 ? cost[i - 1][j] : 0) + 1;
                int del = (j > 0 ? cost[i][j - 1] : 0) + 1;
                int sub = (i > 0 && j > 0 ? cost[i - 1][j - 1] : 0) + (a.charAt(i) == b.charAt(j) ? 0 : 1);
                cost[i][j] = Math.min(del, Math.min(ins, sub));
            }
        }
        for (int i = 0; i < a.length(); i++) {
            System.out.println(Arrays.toString(cost[i]));
        }
        return cost[a.length() - 1][b.length() - 1];
    }
}
