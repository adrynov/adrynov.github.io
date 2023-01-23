package com.adrynov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayTests {
    @Test
    public void findPivotIndex() {
        int[] nums1 = {5, 3, 2, 5, 7, 0};
        int[] nums2 = {-2, -1, -3, 4, -8, 0};
        int[] nums3 = {-20, -10, 3, 9, -8};

        assertEquals(35, ArrayChallenge.maxProduct(nums1));  // 5 * 7 = 35
        assertEquals(24, ArrayChallenge.maxProduct(nums2)); // -3 * -8 = 24
        assertEquals(200, ArrayChallenge.maxProduct(nums3)); // -3 * -8 = 24
    }
}
