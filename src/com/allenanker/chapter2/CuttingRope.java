package com.allenanker.chapter2;

public class CuttingRope {
    /**
     * Solution 2 using greedy algorithm.
     * When n >= 5, 2(n-2) > n and 3(n-3) > n; and 3(n-3) >= 2(n-2), so we should cut out as many 3s and possible.
     *
     * @param length
     * @return
     */
    public static int maxProductAfterCutting_solution2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int numberOfThree = length / 3;
        int remain = length % 3;
        while (remain + 3 < 5) {
            remain += 3;
            numberOfThree--;
        }

        return (int) (remain == 4 ? Math.pow(3, numberOfThree) * 4 : Math.pow(3, numberOfThree) * remain);
    }

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
        System.out.println(maxProductAfterCutting_solution2(8));
    }
}
