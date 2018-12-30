package com.allenanker.chapter6;

public class IntegerIdenticalWithIndex {
    /**
     * Find the integer whose index is identical with its index in a given array.
     *
     * @param nums this array is assumed to be sorted in ascending order
     * @return the integer, return Integer.MIN_VALUE no such number exists
     */
    public int findIntegerIdenticalWithIndex(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid parameter nums");
        }

        if (start < 0 || end > nums.length - 1 || (start == end && nums[start] != start)) {
            return Integer.MIN_VALUE;
        }

        int mid = start + ((end - start) >> 1);
        int midNum = nums[mid];
        if (midNum == mid) {
            return mid;
        } else {
            if (midNum < mid) {
                return findIntegerIdenticalWithIndex(nums, mid + 1, end);
            } else {
                return findIntegerIdenticalWithIndex(nums, start, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, 2, 3, 4, 5, 6};
        IntegerIdenticalWithIndex solution = new IntegerIdenticalWithIndex();
        System.out.println(solution.findIntegerIdenticalWithIndex(nums, 0, nums.length - 1));
    }
}
