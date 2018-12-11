package com.allenanker.chapter2;

public class PrintUntilMaxOfNDigits {
    public static void printUntilMax(int numberOfDigits) {
        if (numberOfDigits < 1) {
            throw new IllegalArgumentException("Invalid parameters: Number of digits must be >= 1");
        }

        printUntilCore("0", numberOfDigits, 0);
    }

    private static void printUntilCore(String numStr, int length, int index) {
        if (index == length) {
            printNum(numStr);
            return;
        }

        for (int i = 0; i < 10; i++) {
            printUntilCore(numStr + i, length, index + 1);
        }
    }

    /**
     * Print the given number string, it may have zeroes as prefix that don't need to be printed.
     *
     * @param numStr
     */
    private static void printNum(String numStr) {
        System.out.println(numStr.replaceFirst("^0*", ""));
    }

    public static void main(String[] args) {
        printUntilMax(2);
        printUntilMax(3);
        printUntilMax(4);
    }
}
