package com.allenanker.chapter5;

import java.util.Arrays;

public class UglyNumber {
    /**
     * Get the ith ugly number starting from 1.
     *
     * @param i the ith ugly number
     * @return
     */
    public static int getUglyNumber(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Invalid parameter i");
        }
        if (i == 1) {
            return 1;
        }

        int[] uglyNums = new int[i];
        uglyNums[0] = 1;
        int currIndex = 1;
        int numIndexMultipliedBy2 = 0;
        int numIndexMultipliedBy3 = 0;
        int numIndexMultipliedBy5 = 0;
        while (currIndex < i) {
            uglyNums[currIndex] = Math.min(Math.min(uglyNums[numIndexMultipliedBy2] * 2,
                    uglyNums[numIndexMultipliedBy3] * 3), uglyNums[numIndexMultipliedBy5] * 5);
            while (uglyNums[numIndexMultipliedBy2] * 2 <= uglyNums[currIndex]) {
                numIndexMultipliedBy2++;
            }
            while (uglyNums[numIndexMultipliedBy3] * 3 <= uglyNums[currIndex]) {
                numIndexMultipliedBy3++;
            }
            while (uglyNums[numIndexMultipliedBy5] * 5 <= uglyNums[currIndex]) {
                numIndexMultipliedBy5++;
            }
            currIndex++;
        }
        System.out.println(Arrays.toString(uglyNums));

        return uglyNums[i - 1];
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(getUglyNumber(i));
        }
    }
}
