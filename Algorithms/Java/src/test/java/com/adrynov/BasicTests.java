package com.adrynov;

import com.adrynov.Basic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTests {

    @Test
    void fibonacci() {
        // 1, 1, 2, 3, 5, 8, 13 and 21.
        assertEquals(1, Basic.fibonacci(1));
        assertEquals(1, Basic.fibonacci(2));

        assertEquals(3, Basic.fibonacci(4));
        assertEquals(5, Basic.fibonacci(5));
        assertEquals(8, Basic.fibonacci(6));
        assertEquals(13, Basic.fibonacci(7));
        assertEquals(21, Basic.fibonacci(8));
        assertEquals(34, Basic.fibonacci(9));
        assertEquals(55, Basic.fibonacci(10));
        assertEquals(89, Basic.fibonacci(11));
        assertEquals(144, Basic.fibonacci(12));
    }

    @Test
    void findMaximumNumber() {
        assertEquals(3, Basic.findMaximum(1, 2, 3));
        assertEquals(8, Basic.findMaximum(8, 8, 1));
        assertEquals(12, Basic.findMaximum(3, 12, 3));
        assertEquals(9, Basic.findMaximum(1, 1, 9));
        assertEquals(9, Basic.findMaximum(9, 1, 5));
    }
}
