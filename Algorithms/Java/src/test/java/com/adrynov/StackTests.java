package com.adrynov;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTests {

    @Test
    void matchingParentheses() {
        String t1 = "(<[ ]>)";
        String t2 = "[<incre>ment]";
        String t3 = "<increment>";
        String t4 = "()incre<>ment<>[]";

        String t5 = "<increment(";
        String t6 = "[)incr]ement(";
        String t7 = "<i(ncr>e)ment";
        String t8 = "(<increment>";

        assertTrue(StackChallenge.matchingParentheses(t1));

    }

}
