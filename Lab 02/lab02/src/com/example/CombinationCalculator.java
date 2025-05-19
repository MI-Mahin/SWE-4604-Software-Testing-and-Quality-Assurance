package com.example;

public class CombinationCalculator {
    public static int combination(int n, int r) {
        if (n < 0 || r < 0 || n > 15 || r > 15) {
            throw new IllegalArgumentException("Inputs must be between 0 and 15 inclusive.");
        }
        if (r > n) {
            return 0;
        }
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    private static int factorial(int x) {
        int result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }
}
