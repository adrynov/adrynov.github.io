package com.adrynov;

import java.util.Map;
import java.util.Stack;

public class StackChallenge {
    private static final Map<Character, Character> blockSymbols = Map.of(
            '{', '}',
            ')', '(',
            ']', '[',
            '>', '<'
    );

    public static boolean matchingParentheses(String input) {
        Stack<Character> characters = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (blockSymbols.containsValue(current)) {
                characters.push(current);
                continue;
            }

            boolean notSame = characters.isEmpty() ||
                    (blockSymbols.get(current) != characters.pop());

            if (blockSymbols.containsKey(current) && notSame ) {
                return false;
            }

        }

        return characters.isEmpty();
    }
}
