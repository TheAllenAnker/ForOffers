package com.allenanker.chapter6;

public class JosephusCircle {
    /**
     * In each counting circle, remove the kth number in current counting.
     *
     * @param nums
     * @param k
     * @return
     */
    public int remainingNumInJC(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            throw new IllegalArgumentException("Invalid parameter(s)");
        }

        int last = 0;
        for (int i = 2; i <= nums.length; i++) {
            last = (last + k) % i;
        }

        return nums[last];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4};
        System.out.println(new JosephusCircle().remainingNumInJC(nums, 3));
    }
}
