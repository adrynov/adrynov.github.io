package com.adrynov;

import java.util.Collections;
import java.util.List;

public class HackerRank {

    /**
     * Given five positive integers, find the minimum and maximum values that can be calculated
     * by summing exactly four of the five integers.
     *
     * @param arr An array of  integers
     * @return A line of two space-separated long integers: the minimum sum and the maximum sum of 4 of 5 elements
     */
    public static String miniMaxSum(List<Integer> arr) {
        long sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0;

        // calculate sums of 4 integers
        for (int i = 0; i < arr.size(); i++) {
            if (i != 0) sum1 += arr.get(i);
            if (i != 1) sum2 += arr.get(i);
            if (i != 2) sum3 += arr.get(i);
            if (i != 3) sum4 += arr.get(i);
            if (i != 4) sum5 += arr.get(i);
        }

        // find the min and max sum
        List<Long> sums = List.of(sum1, sum2, sum3, sum4, sum5);
        long minSum = sums.stream().mapToLong(v -> v).min().orElse(0);
        long maxSum = Collections.max(sums);

        System.out.println(minSum + " " + maxSum);
        return minSum + " " + maxSum;
    }
}
