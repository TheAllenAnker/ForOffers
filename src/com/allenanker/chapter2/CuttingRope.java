package com.allenanker.chapter2;

public class CuttingRope {
    /**
     * Solution 1 using dynamic programming.
     *
     * @param length
     * @return
     */
    public static int maxProductAfterCutting_solution1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i < products.length; i++) {
            int max;
            for (int j = 0; j <= i / 2; j++) {
                max = products[i - j] * products[j];
                products[i] = max > products[i] ? max : products[i];
            }
        }
        return products[length];
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting_solution1(8));
    }
}
