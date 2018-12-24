package com.allenanker.chapter5;

public class NumberOf1 {
    public static int numberOf1(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be larger than 0");
        }
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }

        String numStr = Integer.toString(n);
        int length = numStr.length();

        int first = Integer.parseInt(numStr.substring(0, 1));
        int numFirstDigit;
        if (first > 1) {
            numFirstDigit = (int) Math.pow(10, length - 1);
        } else {
            numFirstDigit = Integer.parseInt(numStr.substring(1)) + 1;
        }

        int numOtherDigits;
        numOtherDigits = (int) (first * (length - 1) * Math.pow(10, length - 2));

        int numRecursive = numberOf1(Integer.parseInt(numStr.substring(1)));

        return numFirstDigit + numOtherDigits + numRecursive;
    }

    public static void main(String[] args) {
        int num = 21345;
        System.out.println(numberOf1(num));
    }
}
