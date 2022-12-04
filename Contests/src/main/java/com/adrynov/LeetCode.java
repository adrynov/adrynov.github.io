package com.adrynov;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * These exercises are marked as Easy.
 */
public class LeetCode {

    /**
     * Given an array of integers nums, calculate the pivot index of this array.
     * <p>
     * The pivot index is the index where the sum of all the numbers strictly to the left of the index
     * is equal to the sum of all the numbers strictly to the index's right.
     * <p>
     * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
     * This also applies to the right edge of the array.
     * <p>
     * <a href="https://leetcode.com/problems/find-pivot-index/>Find Pivot Index</>
     *
     * @param nums Array of integers
     * @return The leftmost pivot index. If no such index exists, return -1.
     */
    public static int findPivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;

        // calculate the full sum
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        // calculate both sums
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            rightSum -= nums[i];
        }

        return -1;
    }

    /**
     * Given two strings s and t, determine if they are isomorphic.
     * <p>
     * Two strings are isomorphic if the characters in s can be replaced to get t.
     * <p>
     * All occurrences of a character must be replaced with another character
     * while preserving the order of characters.
     * <p>
     * No two characters may map to the same character, but a character may map to itself.
     *
     * @param s String 1
     * @param t String 2
     * @return True if both strings are isomorphic
     */
    public static boolean isIsomorphic(String s, String t) {
        // Constraints
        if (s.length() == 0 || s.length() > 5 * 104) return false;
        if (s.length() != t.length()) return false;

        // store the mapping of characters across both strings
        Map<Character, Character> mapping = new HashMap<>();

        // store the characters already mapped
        Set<Character> known = new HashSet<>();

        // iterate over all the characters
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            Character current = mapping.get(c1);

            // the current character is either mapped or not
            if (current != null) {
                if (!current.equals(c2)) return false;  // not isomorphic
            } else {
                if (known.contains(c2)) return false;

                known.add(c2);
                mapping.put(c1, c2);
            }
        }

        return true;
    }

}
