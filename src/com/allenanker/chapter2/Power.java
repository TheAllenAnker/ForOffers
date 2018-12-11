package com.allenanker.chapter2;

public class Power {
    public static double power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }

        return exponent > 0 ? powerOfPositiveExponent_v2(base, exponent) :
                1.0 / powerOfPositiveExponent_v2(base, -exponent);
    }

    public static double powerOfPositiveExponent_v2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        double result = powerOfPositiveExponent_v2(base, exponent >> 1);
        result *= result;
        // if the exponent can't be divided by 2 with no remainder
        if ((exponent & 0x1) == 1) {
            result *= base;
        }
        return result;
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
