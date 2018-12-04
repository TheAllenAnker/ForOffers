package com.allenanker.niuke_advanced_lesson;

import java.util.HashMap;

public class GetChangeWays {
    /**
     * After analyzing the second solution, I figure that only one dimension array is enough
     *
     * @param amounts
     * @param sum
     * @return
     */
    public static int numberOfWays3(int[] amounts, int sum) {
        if (amounts == null || amounts.length == 0 || sum < 0) {
            throw new IllegalArgumentException("amounts cannot be null or empty, sum must be >= 0");
        }

        int[] dp = new int[sum + 1];
        for (int i = 0; i * amounts[0] <= sum; i++) {
            dp[amounts[0] * i] = 1;
        }

        for (int i = 1; i < amounts.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[j] += j - amounts[i] >= 0 ? dp[j - amounts[i]] : 0;
            }
        }

        return dp[sum];
    }

    /**
     * Does the same thing as the first method, but using a dp table inspired by the way we use recursion.
     *
     * @param amounts
     * @param sum
     * @return
     */
    public static int numberOfWays2(int[] amounts, int sum) {
        if (amounts == null || amounts.length == 0 || sum < 0) {
            throw new IllegalArgumentException("amounts cannot be null or empty, sum must be >= 0");
        }

        // may be we can use a map to save some space(HashMap<String, Integer>)
        int[][] dp = new int[amounts.length][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; amounts[0] * i <= sum; i++) {
            dp[0][amounts[0] * i] = 1;
        }

        for (int i = 1; i < amounts.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - amounts[i] >= 0 ? dp[i][j - amounts[i]] : 0;
            }
        }

        return dp[amounts.length - 1][sum];
    }

    /**
     * Use the money in given amounts to make a total change of "sum"
     * This is a bad way to solve this problem. (brutal force)
     *
     * @param amounts the given amounts, each element represent an amount
     * @param sum     the change sum
     * @return
     */
    public static int numberOfWays1(int[] amounts, int sum) {
        if (amounts == null || amounts.length == 0) {
            return 0;
        }

        return process(amounts, 0, sum);
    }

    private static HashMap<String, Integer> dpMap = new HashMap<>();

    private static int process(int[] amounts, int index, int sum) {
        int res = 0;
        // the end condition for recursive calls
        String dpKey = null;
        if (index == amounts.length) {
            res = sum == 0 ? 1 : 0;
        } else {
            // try every ways in a recursive manner
            // if it works, res++, or res does not change
            for (int i = 0; amounts[index] * i <= sum; i++) {
                // optimized a little with a map
                dpKey = index + "_" + sum;
                if (dpMap.containsKey(dpKey)) {
                    res += dpMap.get(dpKey);
                    break;
                } else {
                    res += process(amounts, index + 1, sum - (amounts[index] * i));
                }
            }
        }
        dpMap.put(dpKey, res);

        return res;
    }

    public static void main(String[] args) {
        int[] amounts = new int[]{200, 100, 50};
        System.out.println(numberOfWays1(amounts, 300));
        System.out.println(numberOfWays2(amounts, 300));
        System.out.println(numberOfWays3(amounts, 300));
    }
}
