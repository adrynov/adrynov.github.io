package com.adrynov;

import java.util.Arrays;

public class ArrayChallenge {

    /**
     * Find the maximum product of two numbers.
     * <p>
     * O(n)
     *
     * @param input Unsorted array
     * @return Maximum product
     */
    public static int maxProduct(int[] input) {
        //        assertEquals(35, ArrayChallenge.maxProduct(nums1)); // {5, 3, 2, 5, 7, 0}:  5 * 7 = 35
        //        assertEquals(24, ArrayChallenge.maxProduct(nums2)); // -3 * -8 = 24

        int max1 = 0;
        int max2 = Integer.MIN_VALUE;

        int min1 = 0;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < input.length; i++) {
            int value = input[i];

            if (value < min1) {
                min2 = min1;
                min1 = value;
            } else if (value < min2) {
                min2 = value;
            } else if (value > max1 ) {
                max2 = max1;
                max1 = value;
            } else {
                max2 = value;
            }
        }

        int minProduct = min1 * min2;
        int maxProduct = max1 * max2;

        return Math.max(maxProduct, minProduct);
    }

    /**
     * Find the maximum product of two numbers using nested arrays.
     * <p>
     * O(n^2)
     *
     * @param input
     * @return
     */
    public static int maxProduct2(int[] input) {
        int max = Integer.MIN_VALUE;

        if (input.length < 2) {
            System.out.println("Array too small");
            return max;
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                int current = input[i] * input[j];
                if (current > max) max = current;
            }
        }

        return max;
    }

    public static int maxProduct3(int[] input) {
        if (input.length < 2) {
            System.out.println("Array too small");
            return 0;
        }

        Arrays.sort(input);

        int min = input[0] * input[1];
        int max = input[input.length - 2] * input[input.length - 1];

        return (max > min) ? max : min;

    }
}
