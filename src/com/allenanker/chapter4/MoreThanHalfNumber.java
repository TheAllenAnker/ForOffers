package com.allenanker.chapter4;

import static com.allenanker.chapter4.ArraysUtil.partition;

public class MoreThanHalfNumber {
    public static int moreThanHalfNum_v2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid parameter num");
        }

        int currNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (currNum == nums[i]) {
                count++;
            } else {
                if (count == 0) {
                    currNum = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        return currNum;
    }

    public static int moreThanHalfNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid parameter num");
        }

        int length = nums.length;
        int mid = length >> 1;
        int start = 0, end = length - 1;
        int i = partition(nums, start, end);
        while (i != mid) {
            if (i < mid) {
                start = i + 1;
                i = partition(nums, start, end);
            } else {
                end = i - 1;
                i = partition(nums, start, end);
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3, 3, 2, 5, 4, 3};
        System.out.println(moreThanHalfNum(nums));
        System.out.println(moreThanHalfNum_v2(nums));
    }
}
