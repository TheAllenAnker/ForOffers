package com.allenanker.niuke_advanced_lesson;

import java.util.HashMap;

public class GetChangeWays {
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
    }
}
