package com.allenanker.chapter6;

public class MaxProfit {
    public int getMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("Invalid parameter prices");
        }

        int min = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 2; i < prices.length; i++) {
            min = min < prices[i - 1] ? min : prices[i - 1];
            maxProfit = maxProfit > prices[i] - min ? maxProfit : prices[i] - min;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(new MaxProfit().getMaxProfit(prices));
    }
}
