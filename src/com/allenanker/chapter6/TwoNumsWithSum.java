package com.allenanker.chapter6;

import java.util.Arrays;

public class TwoNumsWithSum {
    public int[] findTwoNumsWithSum_v2(int[] nums, int sum) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        int length = nums.length;
        int aheadI = 0;
        int behindI = length - 1;
        while (aheadI < behindI) {
            int currSum = nums[aheadI] + nums[behindI];
            if (currSum == sum) {
                break;
            } else if (currSum > sum) {
                behindI--;
            } else {
                aheadI++;
            }
        }

        return new int[]{nums[aheadI], nums[behindI]};
    }

    public int[] findTwoNumsWithSum(int[] nums, int sum) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        int num1 = 0;
        int num2 = 0;
        int length = nums.length;
        int rightBound = length;
        outer:
        for (int i = 0; i < length; i++) {
            num1 = nums[i];
            for (int j = i + 1; j < rightBound; j++) {
                num2 = nums[j];
                if (num1 + num2 == sum) {
                    break outer;
                } else if (num1 + num2 > sum) {
                    rightBound = j;
                    break;
                }
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 7, 11, 15};
        System.out.println(Arrays.toString(new TwoNumsWithSum().findTwoNumsWithSum(nums, 15)));
        System.out.println(Arrays.toString(new TwoNumsWithSum().findTwoNumsWithSum_v2(nums, 15)));
    }
}
