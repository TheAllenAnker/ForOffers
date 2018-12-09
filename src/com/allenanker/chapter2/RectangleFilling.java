package com.allenanker.chapter2;

public class RectangleFilling {
    /**
     * Find the number of ways to fill a 2xn rectangle with n 2x1 rectangles.
     *
     * @param n
     * @return
     */
    public static int fillingWays(int n) {
        // f(8) = f(7) + f(6);...
        // f(1) = 1, f(2) = 2;
        if (n < 3) {
            return n;
        }

        int a = 1, b = 2;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(fillingWays(8));
        System.out.println(fillingWays(4));
    }
}
