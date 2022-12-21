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

    /*
     * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
     *
     * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
     *       - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
     */

    public static String convertToMilitaryTime(String s) {
        // Write your code here

        return "";
    }
}
