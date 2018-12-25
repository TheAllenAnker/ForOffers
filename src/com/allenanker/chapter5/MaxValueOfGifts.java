package com.allenanker.chapter5;

public class MaxValueOfGifts {
    /**
     * There is a mxn board with mxn gifts on each box, move right or down from the upper-left corner of the board
     * until reaching the bottom-right corner to pick the max value of gifts.
     *
     * @param board
     * @return
     */
    public static int maxValueOfGifts(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        return board[0][0] + maxPathCore(board, 0, 0, board.length, board[0].length);
    }

    private static int maxPathCore(int[][] board, int i, int j, int row, int col) {
        if (i == row - 1 && j == col - 1) {
            return 0;
        }
        if (i == row - 1) {
            return board[i][j + 1] + maxPathCore(board, i, j + 1, row, col);
        }
        if (j == col - 1) {
            return board[i + 1][j] + maxPathCore(board, i + 1, j, row, col);
        }

        return Math.max(board[i][j + 1] + maxPathCore(board, i + 1, j, row, col),
                board[i + 1][j] + maxPathCore(board, i, j + 1, row, col));
    }

    public static void main(String[] args) {
        int[][] board = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        System.out.println(maxValueOfGifts(board));
    }
}
