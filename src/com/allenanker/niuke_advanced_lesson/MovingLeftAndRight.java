package com.allenanker.niuke_advanced_lesson;

public class MovingLeftAndRight {
    /**
     * Base the recursion I use in the last solution, this problem can be solved easier by building a dp table.
     *
     * @param N
     * @param P
     * @param S
     * @param D
     * @return
     */
    public static int waysToDest2(int N, int P, int S, int D) {
        if (S < 1 || D < 1 || D > N || P < 1 || P > N) {
            return 0;
        }

        // positions from 1 to N is columns from 0 to N - 1
        int[][] dp = new int[S][N];
        if (D - 1 != 0) {
            dp[0][D - 2] = 1;
        }
        if (D - 1 != N - 1) {
            dp[0][D] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] += j != 0 ? dp[i - 1][j - 1] : 0;
                dp[i][j] += j != N - 1 ? dp[i - 1][j + 1] : 0;
            }
        }

        return dp[S - 1][P - 1];
    }

    /**
     * Consider a robot, can only move left or right in each step.
     * Positions are aligned From left to right, numbered from 1 to N.
     * How many ways to get to the final position if the robot can only move S steps.
     * Return 0 if there is no way to get there.
     *
     * @param N N positions in total
     * @param P start position
     * @param S given steps
     * @param D final position (destination)
     * @return number of ways
     */
    public static int waysToDest1(int N, int P, int S, int D) {
        // assuming all the inputs are valid
        if (S == 0) {
            return P == D ? 1 : 0;
        }

        if (P == 1) {
            // it can only move right
            return waysToDest1(N, P + 1, S - 1, D);
        } else if (P == N) {
            // can only move left
            return waysToDest1(N, P - 1, S - 1, D);
        } else {
            return waysToDest1(N, P + 1, S - 1, D) + waysToDest1(N, P - 1, S - 1, D);
        }
    }

    public static void main(String[] args) {
        System.out.println(waysToDest1(5, 2, 3, 3));
        System.out.println(waysToDest2(5, 2, 3, 3));
    }
}
