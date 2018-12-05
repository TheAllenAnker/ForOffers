package com.allenanker.niuke_advanced_lesson;

import java.util.HashMap;

public class SequenceSum {
    /**
     * Return the length of the longest sub-array whose sum is smaller or equal to the target.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int maxLengthSeqWithSmallerSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] minSums = new int[len];
        int[] minSumEnds = new int[len];
        minSums[len - 1] = nums[len - 1];
        minSumEnds[len - 1] = len - 1;
        for (int i = len - 2; i >= 0 ; i--) {
            if (minSums[i + 1] < 0) {
                minSums[i] = nums[i] + minSums[i + 1];
                minSumEnds[i] = minSumEnds[i + 1];
            } else {
                minSums[i] = nums[i];
                minSumEnds[i] = i;
            }
        }

        int max = 0;
        int currMinSum;
        int currMinEnd;
        for (int i = 0; i < len; i++) {
            currMinSum = minSums[i];
            currMinEnd = minSumEnds[i];
            while (currMinSum <= target) {
                max = Math.max(max, currMinEnd - i + 1);
                if (currMinEnd + 1 >= len) {
                    break;
                }
                currMinSum += minSums[currMinEnd + 1];
                currMinEnd = minSumEnds[currMinEnd + 1];
            }
        }

        return max;
    }

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
//        int[] nums = {7, 3, 2, 1, 1, 7, -6, -1, 7};
//        System.out.println(maxLengthSeqSum(nums, 7));

        int[] nums = new int[]{1, -3, 4, -5, 7, 3, -6, 9};
        System.out.println(maxLengthSeqWithSmallerSum(nums, 6));
    }
}
