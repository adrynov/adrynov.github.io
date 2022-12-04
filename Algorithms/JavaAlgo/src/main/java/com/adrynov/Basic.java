package com.adrynov;

public class Basic {

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
