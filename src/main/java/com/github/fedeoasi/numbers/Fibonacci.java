package com.github.fedeoasi.numbers;

public class Fibonacci {
    public static int fibonacci(int n) {
        int first = 1;
        int second = 1;
        int result = first;
        for(int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
