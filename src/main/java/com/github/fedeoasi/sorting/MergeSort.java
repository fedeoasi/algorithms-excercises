package com.github.fedeoasi.sorting;

public class MergeSort implements Sort {
    @Override
    public int[] sort(int[] a) {
        if(a.length == 0) return new int[0];
        return mergeSortInternal(a, 0, a.length - 1);
    }

    private int[] mergeSortInternal(int[] a, int start, int stop) {
        if(start == stop) {
            int[] result = new int[1];
            result[0] = a[start];
            return result;
        }
        int m = (start + stop) / 2;
        int[] left = mergeSortInternal(a, start, m);
        int[] right = mergeSortInternal(a, m + 1, stop);

        return assemble(left, right);
    }

    private int[] assemble(int[] left, int[] right) {
        int totalLength = left.length + right.length;
        int[] result = new int[totalLength];
        int i = 0;
        int j = 0;
        while(i + j < totalLength) {
            if(i >= left.length) {
                result[i + j] = right[j];
                j++;
            } else if (j >= right.length) {
                result[i + j] = left[i];
                i++;
            } else if(left[i] <= right[j]) {
                result[i + j] = left[i];
                i++;
            } else {
                result[i + j] = right[j];
                j++;
            }
        }
        return result;
    }
}
