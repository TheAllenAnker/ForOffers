package com.allenanker.chapter5;

import java.util.HashMap;

public class FirstNotRepeatingChar {
    public static char firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Invalid parameter str");
        }

        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (charCount.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }

        throw new IllegalArgumentException("No such character is found");
    }
    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("abaccdeff"));
    }
}
