package com.adrynov;

public class Basic {

    /**
     * Computes the nth Fibonacci number in the sequence (in which each number is the sum of the two preceding ones)
     * <p>
     * Successive Fibonacci numbers: 1, 1, 2, 3, 5, 8, 13 and 21.
     *
     * @param n The number of Fibonacci numbers to generate.
     * @return Fibonacci sequence.
     */
    public static int fibonacci(int n) {
        // base cases
        if (n == 0) return 0;
        if (n <= 2) return 1;

        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int findMaximum(int a, int b, int c) {
        int max = a;

        if (b > max) max = b;
        if (c > max) max = c;

        return max;
    }

    //<editor-fold desc="Un-optimal">

    public static int findMaximumUnoptimised(int a, int b, int c) {
        if (a > b) {
            if (a > c || a == c) return a;
        }

        if (b > c) return b;

        return c;
    }

    //</editor-fold>
}
