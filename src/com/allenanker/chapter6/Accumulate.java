package com.allenanker.chapter6;

public class Accumulate {
    public Accumulate() {

    }

    public int getAccumulativeSum(int n) {
        int res = n;
        boolean flag = (res > 0) && (res += getAccumulativeSum(n - 1)) > 0;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Accumulate().getAccumulativeSum(4));
    }
}
