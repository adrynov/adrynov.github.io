package com.adrynov;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringProcessing {
    private static final List commonWords = List.of("the", "a", "or", "an", "it", "and",
            "but", "is", "are", "of", "on", "to", "was", "were", "in",
            "that", "i", "your", "his", "their", "her", "you", "me",
            "they", "at", "be");


    public static String findMostRepeatedWord(String text) {
        String result = "";

        var words = text.toLowerCase().trim().split("[ \\n\\t\\r.,;:!?(){]");

        // create a map of words and their count
        Map<String, Integer> wordCount = new HashMap<>();

        Arrays.stream(words)
                .filter(w -> !w.isBlank() && !commonWords.contains(w))
                .forEach(w -> wordCount.merge(w, 1, Integer::sum));

        int maxCount = 0;

        for (var entries : wordCount.entrySet()) {
            if (entries.getValue() >= maxCount) {
                result = entries.getKey();
                maxCount = entries.getValue();
            }
        }


        return result;
    }

    /**
     * Checks if a certain character exists at an even index in the specified string.
     *
     * @param input Input string
     * @param item  A character
     * @return True if the item's index is even
     */
    public static boolean isAtEventIndex(String input, char item) {
        if (input == null || input.isBlank()) return false;

        for (int i = 0; i < input.length() / 2 + 1; i += 2) {
            if (input.charAt(i) == item) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks whether a string contains at least one of the lowercase, uppercase letter and digits.
     *
     * @param value Input string
     * @return True of the input is simple password
     */
    public static boolean isPasswordComplex(String value) {
        return value.chars().anyMatch(Character::isLowerCase) &&
                value.chars().anyMatch(Character::isUpperCase) &&
                value.chars().anyMatch(Character::isDigit);
    }

    /**
     * Checks whether a string has all uppercase letters.
     *
     * @param value Input string
     * @return True if all letters are uppercase
     */
    public static boolean isUppercase(String value) {
        return value.chars().filter(Character::isAlphabetic).allMatch(Character::isUpperCase);
    }

    public static boolean isLowercase(String value) {
        return value.chars().allMatch(Character::isLowerCase);
    }

    /**
     * Checks whether this string contains the specified sequence of char values.
     *
     * @param input Input string
     * @param sub   the sequence to search for
     * @return true if this string contains s, false otherwise
     */
    public static boolean containsString(String input, String sub) {


        return true;
    }

    /**
     * Reverse a string.
     *
     * @param input Input string
     * @return Reversed string
     */
    public static String reverse(String input) {
        if (input == null || input.isEmpty()) return input;

        StringBuffer reversed = new StringBuffer();
//        return reversed.append(input)reverse().toString();

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }

        return reversed.toString();
    }

}

