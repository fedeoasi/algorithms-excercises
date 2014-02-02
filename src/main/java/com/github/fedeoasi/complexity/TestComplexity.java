package com.github.fedeoasi.complexity;

public class TestComplexity {
    public static int algorithm(int N) {
        int sum = 0;
        for (int i = 0; i < N*N; i++)
            for (int j = i; j < N; j++)
                sum++;
        return sum;
    }

    public static void main(String[] args) {
        for(int i = 1; i < 1000000000; i = 2 * i) {
            System.out.println(i + "\t" + algorithm(i));
        }
    }
}
