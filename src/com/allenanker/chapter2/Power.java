package com.allenanker.chapter2;

public class Power {
    public static double power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }

        return exponent > 0 ? powerOfPositiveExponent(base, exponent) : 1.0 / powerOfPositiveExponent(base, -exponent);
    }

    public static double powerOfPositiveExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(1, 0));
        System.out.println(power(-2, 3));
        System.out.println(power(2, 3));
        System.out.println(power(-3, 2));
    }
}
