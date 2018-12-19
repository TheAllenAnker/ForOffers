package com.allenanker.chapter4;

public class StringPermutation {
    public static void printPermutation(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0) {
            throw new IllegalArgumentException("str must not be null or empty");
        }

        permutation(str, 0);
    }

    private static void permutation(String str, int start) {
        if (start == str.length() - 1) {
            System.out.println(str);
        } else {
            for (int i = start; i < str.length(); i++) {
                str = swap(str, start, i);
                permutation(str, start + 1);
                str = swap(str, start, i);
            }
        }
    }

    private static String swap(String str, int a, int b) {
        if (a == b) {
            return str;
        }
        return str.substring(0, a) + str.charAt(b) + str.substring(a + 1, b) + str.charAt(a) + str.substring(b + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        printPermutation(str);
        System.out.println("==============");
        printPermutation("abcd");
    }
}
