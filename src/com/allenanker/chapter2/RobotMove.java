package com.allenanker.chapter2;

public class RobotMove {
    public static int accessibleBlocks(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];
        return blocksCount(threshold, rows, cols, 0, 0, visited);
    }

    private static int blocksCount(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 +
                    blocksCount(threshold, rows, cols, row - 1, col, visited) +
                    blocksCount(threshold, rows, cols, row, col + 1, visited) +
                    blocksCount(threshold, rows, cols, row + 1, col, visited) +
                    blocksCount(threshold, rows, cols, row, col - 1, visited);
        }

        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        return row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold
                && !visited[row * cols + col];
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(accessibleBlocks(1, 2, 2));
    }
}
