package com.allenanker.chapter3;

public class PrintMatrix {
    public static <T> void printMatrix(T[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Invalid matrix");
        }

        int startRow = 0, endRow = matrix.length - 1;
        int startCol = 0, endCol = matrix[0].length - 1;
        while (endRow >= startRow && endCol >= startCol) {
            printMatrixCircle(matrix, startRow++, endRow--, startCol++, endCol--);
        }
        System.out.println();
    }

    private static <T> void printMatrixCircle(T[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        if (endRow >= startRow && endCol >= startCol) {
            for (int i = startCol; i <= endCol; i++) {
                System.out.print(matrix[startRow][i] + ", ");
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + ", ");
            }
            if (startRow != endRow) {
                for (int i = endCol - 1; i >= startCol; i--) {
                    System.out.print(matrix[endRow][i] + ", ");
                }
            }
            if (startCol != endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    System.out.print(matrix[i][startCol] + ", ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Integer[][] matrix2 = {
                {12, 3, 4},
                {5, 2, 1},
        };
        printMatrix(matrix);
        printMatrix(matrix2);
    }
}
