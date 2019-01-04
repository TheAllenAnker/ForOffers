package com.allenanker.chapter6;

import java.util.Arrays;

public class DicesProbabilities {
    public double[] getDicesProbabilities(int n) {
        double[][] probabilities = new double[2][n * 6 + 1];
        int flag = 0;
        for (int i = 1; i < 7; i++) {
            probabilities[flag][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            flag = 1 - flag;
            for (int j = 0; j < i; j++) {
                probabilities[flag][j] = 0;
            }
            for (int j = i; j <= 6 * i; j++) {
                probabilities[flag][j] = 0;
                for (int k = 1; k < j && k <= 6; k++) {
                    probabilities[flag][j] += probabilities[1 - flag][j - k];
                }
            }

        }

        double base = Math.pow(6, n);
        for (int i = n; i < n * 6 + 1; i++) {
            probabilities[flag][i] /= base;
        }
        double[] res = new double[5 * n + 1];
        System.arraycopy(probabilities[flag], n, res, 0, 5 * n + 1);

        return res;
    }

    public static void main(String[] args) {
        DicesProbabilities dp = new DicesProbabilities();
        System.out.println(Arrays.toString(dp.getDicesProbabilities(2)));
    }
}
