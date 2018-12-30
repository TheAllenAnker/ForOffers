package com.allenanker.chapter6;

public class MissingNumber {
    public int missingNumber(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid parameter nums");
        }
        if (start == end) {
            return nums[start] == start ? -1 : 0;
        }

        int mid = start + ((end - start) >> 1);
        if (nums[mid] == mid) {
            if (mid < end && nums[mid + 1] > mid + 1) {
                return mid + 1;
            }
            return missingNumber(nums, mid + 1, end);
        } else if (nums[mid] > mid) {
            if (mid == 0) {
                return 0;
            }
            if (nums[mid - 1] == mid - 1) {
                return mid;
            }
            return missingNumber(nums, start, mid - 1);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int[] nums = new int[]{0, 1, 2, 3, 4, 6};
        System.out.println(solution.missingNumber(nums, 0, nums.length - 1));
    }
}
