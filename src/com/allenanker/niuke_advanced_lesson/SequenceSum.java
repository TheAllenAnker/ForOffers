package com.allenanker.niuke_advanced_lesson;

import java.util.HashMap;

public class SequenceSum {
    /**
     * Calculate the longest sequence in a num list that sum to the target.
     *
     * @param nums   the num list
     * @param target the target
     * @return the max length
     */
    public static int maxLengthSeqSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int currTarget = sum - target;
            if (sumMap.containsKey(currTarget)) {
                len = Math.max(len, i - sumMap.get(currTarget));
            }
            // only put in the sum's first occurrence
            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum, i);
            }
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {7, 3, 2, 1, 1, 7, -6, -1, 7};
        System.out.println(maxLengthSeqSum(nums, 7));
    }
}
