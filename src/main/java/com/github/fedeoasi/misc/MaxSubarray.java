package com.github.fedeoasi.misc;

import java.util.Arrays;

public class MaxSubarray {
    /**
     * Kadane's algorithm.
     */
    public static int[] findMaxSubarray(int[] a) {
        int maxSum = -1;
        int bestStart = 0;
        int bestStop = 0;

        int i = 0;
        int start = 0;
        int sum = 0;
        while(i < a.length) {
            sum += a[i];
            if(sum > maxSum) {
                bestStart = start;
                bestStop = i;
                maxSum = sum;
            }
            if(sum <= 0) {
                sum = 0;
                start = i + 1;
            }
            i++;
        }
        if(maxSum == -1) {
            return new int[0];
        }
        return Arrays.copyOfRange(a, bestStart, bestStop + 1);
    }
}