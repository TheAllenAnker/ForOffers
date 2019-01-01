package com.allenanker.chapter6;

import java.util.Arrays;

public class NumbersAppearTimes {
    public int[] getTwoNumbersThatAppearOnce(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Invalid parameter nums: array nums cannot be null and its length" +
                    " must be bigger than 1");
        }

        int xorRes = 0;
        for (int num : nums) {
            xorRes ^= num;
        }
        int first1Index = findFirstBitIs1(xorRes);

        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            if (indexBitIs1(currNum, first1Index)) {
                num1 ^= currNum;
            } else {
                num2 ^= currNum;
            }
        }

        return new int[]{num1, num2};
    }

    private int findFirstBitIs1(int num) {
        int indexBit = 0;
        while ((num >> indexBit) != 0) {
            indexBit++;
        }

        return 32 - indexBit;
    }

    private boolean indexBitIs1(int num, int index) {
        return (num >> (31 - index) & 1) == 1;

    }

    public static void main(String[] args) {
        NumbersAppearTimes nat = new NumbersAppearTimes();
        System.out.println(nat.findFirstBitIs1(9));
        System.out.println(nat.indexBitIs1(9, 28));
        int[] nums = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        System.out.println(Arrays.toString(nat.getTwoNumbersThatAppearOnce(nums)));
    }
}
