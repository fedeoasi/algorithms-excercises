package com.github.fedeoasi.numbers;

import java.util.ArrayList;
import java.util.List;

public class ErathostenesSieve {
    public static List<Integer> primeNumbersUpTo(int n) {
        if(n < 2) return new ArrayList<>();
        int[] cand = new int[n - 1];
        for(int i = 2; i < n; i++) {
            cand[i - 2] = i;
        }
        double sqrt = Math.sqrt(n);
        for(int i = 2; i <= (int) sqrt; i++) {
            if(cand[i - 2] != 0) {
                for(int j = i * i; j <= n; j++) {
                    if(j % i == 0) {
                        cand[j - 2] = 0;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n - 2; i++) {
            if(cand[i] != 0) {
                result.add(cand[i]);
            }
        }
        return result;
    }
}
