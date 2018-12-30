package com.allenanker.chapter6;

public class NumberOfK {
    public int numberOfK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid parameter nums");
        }

        int firstKIndex = getFirstK(nums, k, 0, nums.length - 1);
        int lastKIndex = getLastK(nums, k, 0, nums.length - 1);
        if (firstKIndex == -1) {
            return 0;
        } else {
            return lastKIndex - firstKIndex + 1;
        }
    }

    private int getFirstK(int[] nums, int k, int start, int end) {
        if (start == end && nums[start] != k) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] > k) {
            return getFirstK(nums, k, start, mid - 1);
        } else if (nums[mid] < k) {
            return getFirstK(nums, k, mid + 1, end);
        } else {
            if (mid > 0 && nums[mid - 1] == k) {
                return getFirstK(nums, k, start, mid - 1);
            } else {
                return mid;
            }
        }
    }

    private int getLastK(int[] nums, int k, int start, int end) {
        if (start == end && nums[start] != k) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] > k) {
            return getLastK(nums, k, start, mid - 1);
        } else if (nums[mid] < k) {
            return getLastK(nums, k, mid + 1, end);
        } else {
            if (mid < nums.length - 1 && nums[mid + 1] == k) {
                return getLastK(nums, k, mid + 1, end);
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        NumberOfK solution = new NumberOfK();
        System.out.println(solution.getFirstK(nums, 3, 0, nums.length - 1));
        System.out.println(solution.getLastK(nums, 3, 0, nums.length - 1));
        System.out.println(solution.numberOfK(nums, 3));
    }
}
