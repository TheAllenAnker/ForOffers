package com.allenanker.niuke_advanced_lesson;

import java.util.HashMap;

public class XORSumToZero {
    /**
     * Divide the number list into a number of groups, return the max number of groups whose xor sum is zero.
     *
     * @param nums the number list
     * @return the max number of groups
     */
    public static int numberOfGroups(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        int xor = 0;
        int[] dp = new int[nums.length];
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            // the xor sum until i
            xor ^= nums[i];
            if (sumMap.containsKey(xor)) {
                // if the total xor sum appears before, then the sequence's xor sum between pre + 1 and i must be zero
                // so the current answer should increment by 1
                int pre = sumMap.get(xor);
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
            }
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            sumMap.put(xor, i);
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 1, 2, 3};
        // the divided groups will be {3, 2, 1}, {0}, {1, 2, 3}
        System.out.println(numberOfGroups(nums));
    }
}
